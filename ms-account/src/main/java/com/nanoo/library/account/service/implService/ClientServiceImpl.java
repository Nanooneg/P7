package com.nanoo.library.account.service.implService;

import com.nanoo.library.account.service.contractService.ClientService;
import com.nanoo.library.account.database.ClientRepository;
import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.model.entities.Client;
import com.nanoo.library.account.model.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 22/11/2019 - 14:48
 */
@Service
public class ClientServiceImpl implements ClientService {
    
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }
    
    @Override
    public List<ClientDto> getClientList(){
        List<ClientDto> clientDtos = new ArrayList<>();
        
        List<Client> clients = clientRepository.findAll();
        
        for (Client client : clients){
            clientDtos.add(clientMapper.fromClientToDto(client));
        }
        
        return clientDtos;
    }
}
