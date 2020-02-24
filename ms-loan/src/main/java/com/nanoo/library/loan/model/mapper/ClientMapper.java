package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author nanoo
 * @create 23/01/2020 - 12:17
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    
    Client fromDtoToClient (ClientDto clientDto);
    
    ClientDto fromClientToDto (Client client);
    
}
