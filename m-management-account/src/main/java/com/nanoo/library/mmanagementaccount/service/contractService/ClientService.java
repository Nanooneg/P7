package com.nanoo.library.mmanagementaccount.service.contractService;

import com.nanoo.library.mmanagementaccount.model.dto.ClientDto;

import java.util.List;

/**
 * @author nanoo
 * @create 22/11/2019 - 13:42
 */
public interface ClientService {
    
    List<ClientDto> getClientList();
    
}
