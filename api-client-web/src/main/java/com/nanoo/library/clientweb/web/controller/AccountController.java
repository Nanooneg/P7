package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.model.beans.user.AccountBean;
import com.nanoo.library.clientweb.model.beans.user.UserBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import com.nanoo.library.commonpackage.security.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    private static final String ACCOUNT_ATT = "accountBean";
    private static final String ERROR_ATT = "errorMessage";
    private static final String ERROR_MSG = "ERREUR! Les modifications n'ont pas été enregistrées!";
    
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
    
        AccountBean accountBean = proxy.getAccountInfo(accessToken);
        
        model.addAttribute(ACCOUNT_ATT,accountBean);
        
        return ACCOUNT_FORM_VIEW;
    }
    
    @PostMapping("/update/profile")
    public String updateClientProfile (@Valid AccountBean accountBean, Model model, BindingResult bindingResult, HttpServletResponse response,
                                       @CookieValue(value = CommonSecurityConfig.HEADER,required = false) String accessToken){
        
        if (accessToken == null) return REDIRECT_LOGIN_VIEW;
        
        if (bindingResult.hasErrors()){
            model.addAttribute(ACCOUNT_ATT,accountBean);
            return ACCOUNT_FORM_VIEW;
        }
        
        AccountBean editedAccount = proxy.editAccount(accessToken,accountBean);
    
        if (editedAccount != null) {
            // Refresh cookie after mail/username update
            UserBean userUpdated = new UserBean(editedAccount.getEmail(),null);
            String jwtToken = proxy.doUpdateToken(accessToken,userUpdated);
            JwtTokenUtils.clear(response);
            Cookie cookie = JwtTokenUtils.generateCookie(jwtToken);
            response.addCookie(cookie);
            
            return REDIRECT_USER_HOME_VIEW;
        } else {
            model.addAttribute(ACCOUNT_ATT,accountBean);
            model.addAttribute(ERROR_ATT,ERROR_MSG);
            
            return ACCOUNT_FORM_VIEW;
        }
    }
    
}
