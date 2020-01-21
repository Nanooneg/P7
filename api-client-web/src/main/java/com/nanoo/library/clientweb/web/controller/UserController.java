package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.beans.loan.LoanBean;
import com.nanoo.library.clientweb.beans.user.AccountBean;
import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import com.nanoo.library.commonsecurity.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author nanoo
 * @create 11/12/2019 - 13:11
 */
@Controller
@RequestMapping("/utilisateur")
public class UserController {
    
    private static final String LIBRARY_ATT = "libraries";
    private static final String USER_ATT = "user";
    private static final String ACCOUNT_ATT = "account";
    private static final String LOAN_LIST_ATT = "loans";
    
    private static final String LOGIN_VIEW = "login";
    private static final String USER_HOME_VIEW = "userHome";
    
    private FeignProxy proxy;
    
    @Autowired
    public UserController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping("/home")
    public String displayUserDashBoard (HttpServletRequest request, Model model){
    
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        String accessToken = JwtTokenUtils.getToken(request);
        
        if (accessToken == null){
            model.addAttribute(USER_ATT,new UserBean());
            return LOGIN_VIEW;
        }
    
        // TODO problem when i try to access few minutes later...
        AccountBean accountInfo = proxy.getAccountInfo(accessToken);
        List<LoanBean> userLoans = proxy.getUserLoanList(accessToken,accountInfo.getId());
        model.addAttribute(ACCOUNT_ATT,accountInfo);
        model.addAttribute(LOAN_LIST_ATT,userLoans);
    
        return USER_HOME_VIEW;
        
    }
    
}
