package com.nanoo.library.mmanagementbook.model.mapper;

import com.nanoo.library.mmanagementbook.model.dto.BookDto;
import com.nanoo.library.mmanagementbook.model.entities.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:35
 */
@Mapper(componentModel = "spring")
public interface BookMapper {
    
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
    
    Book fromDtoToBook (BookDto bookDto);
    
    @InheritInverseConfiguration
    BookDto fromBookToDto (Book book);
    
}
