package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.AccountBean;
import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.FeignProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    private static final String LIBRARY_ATT = "libraries";
    private static final String USER_ATT = "user";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String USERNAME_FIELD = "username";
    
    private static final String LOGIN_VIEW = "login";
    private static final String USER_HOME_VIEW = "userHome";
    
    private FeignProxy proxy;
    
    @Autowired
    public LoginController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/login")
    public String loginForm(Model model){
    
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        model.addAttribute(USER_ATT,new UserBean());
        
        return LOGIN_VIEW;
        
    }
    
    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute ("user") UserBean user, Model model,
                            HttpServletResponse response, BindingResult bindingResult){
        
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        
        // form validation
        if (bindingResult.hasErrors()){
            model.addAttribute(USER_ATT,user);
            return LOGIN_VIEW;
        }
        
        // Authenticate user and get back token
        String jwtToken = proxy.doLogin(user);
        if (jwtToken == null) {
            
            bindingResult.addError(new FieldError(USER_ATT, USERNAME_FIELD, "Mauvais login/mot de passe"));
            model.addAttribute(USER_ATT,user);
            
            return LOGIN_VIEW;
        } else {
            
            // Add token to response in a cookie
            Cookie cookie = CookieUtil.generateCookie(jwtToken);
            response.addCookie(cookie);

            AccountBean accountInfo = proxy.getAccountInfo(jwtToken);
            model.addAttribute(ACCOUNT_ATT,accountInfo);
            
            return USER_HOME_VIEW;
        }
    
    }
    
}
