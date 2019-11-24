package com.nanoo.library.mmanagementaccount.web.controller;

import com.nanoo.library.mmanagementaccount.service.contractService.ClientService;
import com.nanoo.library.mmanagementaccount.model.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final ClientService clientService;
    
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @GetMapping("/clients")
    public List<ClientDto> listAllClient(){
    
        logger.info("Récupération de la liste des clients - MS accout controller");
        
        return clientService.getClientList();
        
    }
}
