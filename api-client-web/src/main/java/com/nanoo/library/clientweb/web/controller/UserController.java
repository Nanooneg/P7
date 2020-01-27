package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.model.beans.loan.LoanBean;
import com.nanoo.library.clientweb.model.beans.user.AccountBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author nanoo
 * @create 11/12/2019 - 13:11
 */
@Controller
@RequestMapping("/utilisateur")
public class UserController {
    
    private static final String LIBRARY_ATT = "libraries";
    private static final String ACCOUNT_ATT = "account";
    private static final String LOAN_LIST_ATT = "loans";
    
    private static final String USER_HOME_VIEW = "userHome";
    private static final String REDIRECT_LOGIN_VIEW = "redirect:/login";
    private static final String REDIRECT_USER_HOME_VIEW = "redirect:/utilisateur/home/selection";
    
    private FeignProxy proxy;
    
    @Autowired
    public UserController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping({"/home","/home/{loanProperty}"})
    public String displayUserDashBoard(Model model, @PathVariable(required = false) String loanProperty,
                                       @CookieValue(value = CommonSecurityConfig.HEADER,required = false) String accessToken){
        
        if (accessToken == null) return REDIRECT_LOGIN_VIEW;
        
        if (loanProperty == null) loanProperty = "all";
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        
        AccountBean accountInfo = proxy.getAccountInfo(accessToken);
        List<LoanBean> userLoans;
        
        userLoans = proxy.getUserLoanList(accessToken,accountInfo.getId(),loanProperty);
        
        model.addAttribute(ACCOUNT_ATT,accountInfo);
        model.addAttribute(LOAN_LIST_ATT,userLoans);
    
        return USER_HOME_VIEW;
        
    }
    
    @GetMapping("/etendre/{loanId}")
    public String extendLoanExpectedReturnDate(@CookieValue(value = CommonSecurityConfig.HEADER,required = false) String accessToken,
                                               @PathVariable int loanId){
        
        proxy.extendLoanExpectedReturnDate(accessToken,loanId);
        
        return REDIRECT_USER_HOME_VIEW;
    }
    
}
