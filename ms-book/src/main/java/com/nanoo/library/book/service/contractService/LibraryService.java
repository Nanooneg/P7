package com.nanoo.library.book.service.contractService;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.LibraryDto;
import com.nanoo.library.book.model.entities.Library;
import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:05
 */
public interface LibraryService {
    
    List<LibraryDto> getLibraryList();
    
    List<BookDto> getBookList(int library);
    
    List<BookDto> getSearchResultByLibrary(boolean available, String searchAttribut, String searchCriteria, int libraryId);
    
    Library findById(int libraryId);
}
