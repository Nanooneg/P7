package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.BookDto;
import com.nanoo.library.loan.model.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author nanoo
 * @create 23/01/2020 - 12:14
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    
    Book fromDtoToBook (BookDto bookDto);
    
    BookDto fromBookToDto (Book book);
    
}
