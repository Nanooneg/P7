package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.AccountDto;
import com.nanoo.library.loan.model.entities.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:54
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);
    
    Account fromDtoToAccount (AccountDto accountDto);
    
    @InheritInverseConfiguration
    AccountDto fromAccountToDto (Account account);
    
}
