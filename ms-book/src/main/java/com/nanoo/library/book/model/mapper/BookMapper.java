package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookInfoLoanDto;
import com.nanoo.library.book.model.dto.BookWithoutCopiesDto;
import com.nanoo.library.book.model.dto.CoverOnlyPathDto;
import com.nanoo.library.book.model.entities.Book;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:35
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {AuthorMapper.class, CopyBookMapper.class, CoverOnlyPathDto.class})
public interface BookMapper {
    
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
    
    @Mappings({
            @Mapping(source = "category.name", target = "category")
    })
    BookDto fromBookToDto (Book book);
    
    @InheritInverseConfiguration
    Book fromDtoToBook (BookDto bookDto);
    
    BookInfoLoanDto fromBookToForLoanDto (Book book);
    
    BookWithoutCopiesDto fromBookToBookWithoutCopiesDto (Book book);
}
