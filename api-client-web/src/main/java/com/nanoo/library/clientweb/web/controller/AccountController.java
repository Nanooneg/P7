package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.model.beans.user.AccountBean;
import com.nanoo.library.clientweb.model.beans.user.UserBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import com.nanoo.library.commonpackage.security.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author nanoo
 * @create 24/01/2020 - 11:09
 */
@Controller
public class AccountController {
    
    private static final String ACCOUNT_ATT = "account";
    
    private static final String ACCOUNT_FORM_VIEW = "accountForm";
    private static final String REDIRECT_LOGIN_VIEW = "redirect:/login";
    private static final String REDIRECT_USER_HOME_VIEW = "redirect:/utilisateur/home/selection";
    
    private FeignProxy proxy;
    
    @Autowired
    public AccountController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping("/edit/profile")
    public String displayAccountForm (Model model, @CookieValue(value = CommonSecurityConfig.HEADER,required = false) String accessToken){
    
        if (accessToken == null) return REDIRECT_LOGIN_VIEW;
    
        AccountBean accountInfo = proxy.getAccountInfo(accessToken);
        
        model.addAttribute(ACCOUNT_ATT,accountInfo);
        
        return ACCOUNT_FORM_VIEW;
    }
    
    @PostMapping("/update/profile")
    public String updateClientProfile (@Valid @ModelAttribute("account") AccountBean accountBean, Model model,
                                       BindingResult bindingResult, HttpServletResponse response,
                                       @CookieValue(value = CommonSecurityConfig.HEADER,required = false) String accessToken){
        
        if (accessToken == null) return REDIRECT_LOGIN_VIEW;
        
        AccountBean editedAccount = proxy.editAccount(accessToken,accountBean);
    
        // Refresh cookie after mail/username update
        UserBean userUpdated = new UserBean();
        userUpdated.setUsername(editedAccount.getEmail());
        String jwtToken = proxy.doUpdateToken(accessToken,userUpdated);
        JwtTokenUtils.clear(response);
        Cookie cookie = JwtTokenUtils.generateCookie(jwtToken);
        response.addCookie(cookie);
        
        if (editedAccount == null) {
            model.addAttribute(ACCOUNT_ATT,accountBean);
            model.addAttribute("errorMessage","ERREUR! Les modifications n'ont pas été enregistrées!");
            return ACCOUNT_FORM_VIEW;
        }else {
            return REDIRECT_USER_HOME_VIEW;
        }
    }
    
}
