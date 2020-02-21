package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookInfoLoanDto;
import com.nanoo.library.book.model.dto.BookWithoutCopiesDto;
import com.nanoo.library.book.model.dto.CoverOnlyPathDto;
import com.nanoo.library.book.model.entities.Book;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
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
    
    Book fromBookWithoutCopiesDtoToBook (BookWithoutCopiesDto withoutCopiesDto);
    
    List<BookDto> fromBooksToDtos (List<Book> books);
    
    List<Book> fromDtosToBooks (List<BookDto> bookDtos);
    
    List<BookWithoutCopiesDto> fromBooksToWithoutCopiesDtos (List<Book> books);
    
    List<Book> fromWithoutCopiesDtosToBooks (List<BookWithoutCopiesDto> bookWithoutCopiesDtos);
    
}
