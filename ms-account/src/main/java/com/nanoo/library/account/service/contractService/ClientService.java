package com.nanoo.library.account.service.contractService;

import com.nanoo.library.account.model.dto.ClientDto;

import java.util.List;

/**
 * @author nanoo
 * @create 22/11/2019 - 13:42
 */
public interface ClientService {
    
    List<ClientDto> getClientList();
    
    ClientDto getLoggedClientInfo();
}
