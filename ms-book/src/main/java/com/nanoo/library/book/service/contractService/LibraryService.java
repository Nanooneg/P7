package com.nanoo.library.book.service.contractService;

import com.nanoo.library.book.model.dto.LibraryWithoutBooksDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:05
 */
public interface LibraryService {
    
    List<LibraryWithoutBooksDto> getLibraryList();
    
}
