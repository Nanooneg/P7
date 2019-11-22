package com.nanoo.library.mmanagementaccount.model.mapper;

import com.nanoo.library.mmanagementaccount.model.dto.ClientDto;
import com.nanoo.library.mmanagementaccount.model.entities.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 22/11/2019 - 11:40
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {
    
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);
    
    Client fromDtoToAccount (ClientDto accountDTO);
    
    @InheritInverseConfiguration
    ClientDto fromAccountToDto (Client account);

}
