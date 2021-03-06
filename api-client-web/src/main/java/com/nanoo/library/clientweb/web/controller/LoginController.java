package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.model.beans.user.UserBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import com.nanoo.library.commonpackage.security.JwtTokenUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
  
  private static final String LIBRARY_ATT = "libraries";
  private static final String USER_ATT = "user";
  
  private static final String USERNAME_FIELD = "username";
  private static final String BAD_CREDENTIALS_MSG = "Mauvais login/mot de passe";
  
  private static final String LOGIN_VIEW = "login";
  private static final String REDIRECT_LOGIN_VIEW = "redirect:/login";
  private static final String REDIRECT_USER_HOME_VIEW = "redirect:/utilisateur/home/selection";
  
  private FeignProxy proxy;
  
  @Autowired
  public LoginController(FeignProxy proxy) {
    this.proxy = proxy;
  }
  
  @GetMapping("/login")
  public String loginForm(Model model) {
    
    model.addAttribute(LIBRARY_ATT, proxy.listAllLibrary());
    model.addAttribute(USER_ATT, new UserBean());
    
    return LOGIN_VIEW;
    
  }
  
  @PostMapping("/login")
  public String loginUser(@ModelAttribute(USER_ATT) UserBean user, Model model,
    HttpServletResponse response, BindingResult bindingResult) {
    
    model.addAttribute(LIBRARY_ATT, proxy.listAllLibrary());
    
    // Authenticate user and receive token
    String jwtToken = proxy.doLogin(user);
    if (jwtToken == null) {
      
      bindingResult.addError(new FieldError(USER_ATT, USERNAME_FIELD, BAD_CREDENTIALS_MSG));
      model.addAttribute(USER_ATT, user);
      
      return LOGIN_VIEW;
    } else {
      
      // Add token to response in a cookie
      Cookie cookie = JwtTokenUtils.generateCookie(jwtToken);
      response.addCookie(cookie);
      
      return REDIRECT_USER_HOME_VIEW;
    }
    
  }
  
  @GetMapping("/logout")
  public String logoutUser(HttpServletResponse response) {
    
    JwtTokenUtils.clear(response);
    
    return REDIRECT_LOGIN_VIEW;
  }
  
}
