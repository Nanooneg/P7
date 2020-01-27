package com.nanoo.library.account.web.controller;

import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.service.contractService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 24/01/2020 - 11:56
 */
@RestController
@RequestMapping("/edit")
public class ClientEditController {
    
    private final ClientService clientService;
    
    @Autowired
    public ClientEditController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @PostMapping("/account")
    public ClientDto editClientProfile (@RequestBody ClientDto clientDto){
        
        return clientService.updateClient(clientDto);
        
    }
    
}
