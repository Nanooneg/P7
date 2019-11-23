package com.nanoo.library.mmanagementbook.model.mapper;

import com.nanoo.library.mmanagementbook.model.dto.LibraryDto;
import com.nanoo.library.mmanagementbook.model.entities.Library;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:48
 */
@Mapper(componentModel = "spring")
public interface LibraryMapper {
    
    LibraryMapper MAPPER = Mappers.getMapper(LibraryMapper.class);
    
    Library fromDtoToLibrary (LibraryDto libraryDto);
    
    @InheritInverseConfiguration
    LibraryDto fromLibraryToDto (Library library);
    
}
