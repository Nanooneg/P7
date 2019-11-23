package com.nanoo.library.mmanagementaccount.web.controller;

import com.nanoo.library.mmanagementaccount.service.contractService.ClientService;
import com.nanoo.library.mmanagementaccount.model.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 22/11/2019 - 11:29
 */
@RestController
public class ClientController {
    
    private final ClientService clientService;
    
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @GetMapping("/clients")
    public List<ClientDto> listAllClient(){
    
        return clientService.getClientList();
        
    }
}
