package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:20
 */
@RestController("/consult")
public class BookController {
    
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/books")
    public List<BookDto> listAllBooks(){
        
        return bookService.getBookList();
        
    }
    
    @GetMapping("/book/{id}")
    public BookDto getOneBook(@PathVariable int id){
        
        return bookService.getBook(id);
        
    }
}
