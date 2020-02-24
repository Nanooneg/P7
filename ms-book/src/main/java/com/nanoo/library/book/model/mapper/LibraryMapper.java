package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.LibraryDto;
import com.nanoo.library.book.model.dto.LibraryInfoLoanDto;
import com.nanoo.library.book.model.entities.Library;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:48
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibraryMapper {
    
    Library fromDtoToLibrary (LibraryDto libraryDto);
    
    LibraryDto fromLibraryToDto (Library library);
    
    LibraryInfoLoanDto fromLibraryToForLoanDto (Library library);
    
    List<Library> fromDtosToLibraries (List<LibraryDto> libraryDtos);
    
    List<LibraryDto> fromLibrariesToDtos (List<Library> libraries);
    
}
