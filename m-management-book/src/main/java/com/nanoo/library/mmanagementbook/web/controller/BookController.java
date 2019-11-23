package com.nanoo.library.mmanagementbook.web.controller;

import com.nanoo.library.mmanagementbook.model.dto.BookDto;
import com.nanoo.library.mmanagementbook.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:20
 */
@RestController
public class BookController {
    
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/livres")
    public List<BookDto> listAllBooks(){
        
        return bookService.getBookList();
        
    }
}
