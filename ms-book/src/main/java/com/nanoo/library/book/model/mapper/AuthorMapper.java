package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.AuthorDto;
import com.nanoo.library.book.model.entities.Author;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:44
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
    
    Author fromDtoToAuthor (AuthorDto authorDto);
    
    AuthorDto fromAuthorToDto (Author author);
    
    List<Author> fromAuthorsDtosToAuthors (List<AuthorDto> authorDtos);
    
    List<AuthorDto> fromAuthorsToAuthorsDtos (List<Author> authors);
    
}
