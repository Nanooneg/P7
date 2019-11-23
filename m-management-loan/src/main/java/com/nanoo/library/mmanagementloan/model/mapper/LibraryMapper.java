package com.nanoo.library.mmanagementloan.model.mapper;

import com.nanoo.library.mmanagementloan.model.dto.LibraryDto;
import com.nanoo.library.mmanagementloan.model.entities.Library;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:55
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibraryMapper {
    
    LibraryMapper MAPPER = Mappers.getMapper(LibraryMapper.class);
    
    Library fromDtoToLibrary (LibraryDto libraryDto);
    
    @InheritInverseConfiguration
    LibraryDto fromLibraryToDto (Library account);
    
}
