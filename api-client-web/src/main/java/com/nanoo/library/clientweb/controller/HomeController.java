package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.proxies.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 11/12/2019 - 15:53
 */
@Controller
public class HomeController {
    
    private static final String LIBRARY_ATT = "libraries";
    
    private static final String HOME_VIEW = "home";
    
    private FeignProxy proxy;
    
    @Autowired
    public HomeController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping({"/home","/index","/"})
    public String home(Model model){
    
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        
        return HOME_VIEW;
        
    }
    
}
