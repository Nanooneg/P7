package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookWithoutAuthorsAndLibraryDto;
import com.nanoo.library.book.model.entities.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:35
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
    
    Book fromDtoToBook (BookDto bookDto);
    
    @InheritInverseConfiguration
    BookDto fromBookToDto (Book book);
    
    BookWithoutAuthorsAndLibraryDto fromBookToDtoWithoutAuthors (Book book);
    
}
