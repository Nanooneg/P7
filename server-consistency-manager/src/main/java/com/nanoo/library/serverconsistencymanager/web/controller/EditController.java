package com.nanoo.library.serverconsistencymanager.web.controller;

import com.nanoo.library.serverconsistencymanager.model.beans.user.ClientBean;
import com.nanoo.library.serverconsistencymanager.service.contractService.AccountEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nanoo
 * @create 24/01/2020 - 15:57
 */
@RestController
@RequestMapping("/edit")
public class EditController {
    
    private AccountEditService accountEditService;
    
    @Autowired
    public EditController(AccountEditService accountEditService) {
        this.accountEditService = accountEditService;
    }
    
    @PutMapping("/account")
    public ClientBean edit (@RequestHeader("Authorization") String accessToken, @RequestBody ClientBean clientBean){
        
        return accountEditService.editAccount(accessToken,clientBean);
        
    }
    
}
