package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.AuthorDto;
import com.nanoo.library.book.model.entities.Author;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:44
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
    
    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);
    
    Author fromDtoToAuthor (AuthorDto authorDto);
    
    @InheritInverseConfiguration
    AuthorDto fromAuthorToDto (Author author);
    
}
