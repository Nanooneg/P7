package com.nanoo.library.account.model.mapper;

import com.nanoo.library.account.model.dto.AddressDto;
import com.nanoo.library.account.model.entities.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author nanoo
 * @create 21/02/2020 - 16:36
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
  
  @Mappings({
    @Mapping(source = "city.name", target = "city")
  })
  AddressDto fromAddressToDto (Address address);
  
  @InheritInverseConfiguration
  Address fromDtoToAddress (AddressDto addressDto);
  
}
