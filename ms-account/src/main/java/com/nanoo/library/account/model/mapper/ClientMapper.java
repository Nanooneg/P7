package com.nanoo.library.account.model.mapper;

import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.model.entities.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author nanoo
 * @create 22/11/2019 - 11:40
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface ClientMapper {
    
    Client fromDtoToClient (ClientDto clientDto);
    
    @InheritInverseConfiguration
    ClientDto fromClientToDto (Client client);

}
