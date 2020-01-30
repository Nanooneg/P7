package com.nanoo.library.account.web.controller;

import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.service.contractService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @PutMapping("/account")
    public ClientDto editClientProfile (@RequestBody ClientDto clientDto){
        
        return clientService.updateClient(clientDto);
        
    }
    
}
