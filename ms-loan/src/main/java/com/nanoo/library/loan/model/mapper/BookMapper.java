package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.BookDto;
import com.nanoo.library.loan.model.entities.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/01/2020 - 12:14
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
    
    Book fromDtoToBook (BookDto bookDto);
    
    @InheritInverseConfiguration
    @Mapping(source = "condition.entitled", target = "condition")
    BookDto fromBookToDto (Book book);
    
}
