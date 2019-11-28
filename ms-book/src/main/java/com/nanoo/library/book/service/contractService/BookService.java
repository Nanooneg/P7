package com.nanoo.library.book.service.contractService;

import com.nanoo.library.book.model.dto.BookDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:03
 */
public interface BookService {
    
    List<BookDto> getBookList();
    
    BookDto getBook(int id);
}
