package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:20
 */
@RestController
@RequestMapping("/consult")
public class BookController {
    
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/book-catalog")
    public List<BookDto> listAllBooks(){
        
        return bookService.getBookList();
        
    }
    
    @GetMapping("/search-result")
    @ResponseBody
    public List<BookDto> getSearchResult(@RequestParam(value = "available",required = false) boolean available,
                                         @RequestParam(value = "searchValue",required = false) String searchValue,
                                         @RequestParam(value = "searchCriteria",required = false) String searchCriteria){
        
    
        return bookService.getSearchResult(available,searchValue,searchCriteria);
        
    }
    
    @GetMapping("/book-detail/{id}")
    public BookDto getBookDetail(@PathVariable int id){
        
        return bookService.getBook(id);
        
    }
}