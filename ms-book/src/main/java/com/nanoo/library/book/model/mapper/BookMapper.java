package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookWithoutAuthorsAndLibraryDto;
import com.nanoo.library.book.model.entities.Book;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:35
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
    
    @InheritInverseConfiguration
    Book fromDtoToBook (BookDto bookDto);
    
    @Mappings({
        @Mapping(source = "condition.entitled", target = "condition"),
        @Mapping(source = "category.name", target = "category")
    })
    BookDto fromBookToDto (Book book);
    
    @InheritInverseConfiguration
    Book fromDtoToBook (BookWithoutAuthorsAndLibraryDto bookWithoutAuthorsAndLibraryDto);
    
    @Mappings({
        @Mapping(source = "condition.entitled", target = "condition"),
        @Mapping(source = "category.name", target = "category")
    })
    BookWithoutAuthorsAndLibraryDto fromBookToDtoWithoutAuthors (Book book);
  
}
