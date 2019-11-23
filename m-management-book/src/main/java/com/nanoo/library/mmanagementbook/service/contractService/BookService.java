package com.nanoo.library.mmanagementbook.service.contractService;

import com.nanoo.library.mmanagementbook.model.dto.BookDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:03
 */
public interface BookService {
    
    List<BookDto> getBookList();
    
}
