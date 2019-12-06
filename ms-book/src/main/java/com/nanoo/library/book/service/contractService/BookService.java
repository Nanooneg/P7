package com.nanoo.library.book.service.contractService;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.entities.Library;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:03
 */
public interface BookService {
    
    List<BookDto> getBookList();
    
    List<BookDto> getLastRegisteredBook();
    
    List<BookDto> getLastRegisteredBookOfLibrary(Library library);
    
    List<BookDto> getSearchResult(boolean available, String title, String author, String libraryId);
}
