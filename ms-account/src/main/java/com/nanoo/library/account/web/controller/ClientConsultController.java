package com.nanoo.library.account.web.controller;

import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.service.contractService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 22/11/2019 - 11:29
 */
@RestController
@RequestMapping("/consult")
public class ClientConsultController {
    
    private final ClientService clientService;
    
    @Autowired
    public ClientConsultController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @GetMapping("/clients")
    public List<ClientDto> listAllClient(){
        
        return clientService.getClientList();
        
    }
    
    @GetMapping("/user-info")
    public ClientDto getClientInfo(){
    
        return clientService.getLoggedClientInfo();
        
    }
}
