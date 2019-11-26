package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.proxies.MManagementAccountProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 23/11/2019 - 23:21
 */
@Controller
public class ClientController {
    
    private final MManagementAccountProxy accountProxy;
    
    @Autowired
    public ClientController(MManagementAccountProxy accountProxy) {
        this.accountProxy = accountProxy;
    }
    
    @GetMapping("/clients")
    public String displayAllClients(Model model){
        
        model.addAttribute("clients",accountProxy.listAllClient());
        
        return "Client";
    }
    
}
