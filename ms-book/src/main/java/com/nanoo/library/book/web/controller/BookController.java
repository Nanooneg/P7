package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookInfoLoanDto;
import com.nanoo.library.book.model.entities.Library;
import com.nanoo.library.book.service.contractService.BookService;
import com.nanoo.library.book.service.contractService.LibraryService;
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
    private final LibraryService libraryService;
    
    @Autowired
    public BookController(BookService bookService, LibraryService libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }
    
    @GetMapping("/book-catalog")
    public List<BookDto> listAllBooks(){
        
        return bookService.getBookList();
        
    }
    
    /*@GetMapping("/book-last")
    public List<BookDto> getLastRegisteredBook(){
        
        return bookService.getLastRegisteredBook();
        
    }
    
    @GetMapping("/{library}/book-last")
    public List<BookDto> getLastRegisteredBookOfLibrary(@PathVariable("library") String libraryId){
    
        Library library = libraryService.findById(Integer.parseInt(libraryId));
        
        return bookService.getLastRegisteredBookOfLibrary(library);
        
    }*/
    
    @GetMapping("/search-result")
    @ResponseBody
    public List<BookDto> getSearchResult(@RequestParam(value = "available",required = false) boolean available,
                                         @RequestParam(value = "searchValue",required = false) String searchValue,
                                         @RequestParam(value = "searchCriteria",required = false) String searchCriteria,
                                         @RequestParam(value = "libraryId",required = false) String libraryId){
        if (Integer.parseInt(libraryId) == 0)
            return bookService.getSearchResult(available,searchValue,searchCriteria);
        else
            return null; // TODO
    }
    
    /*@GetMapping("/book/{bookId}")
    public BookInfoLoanDto getBookInfo(@PathVariable int bookId){
        return bookService.getBookInfo(bookId);
    }*/
  
}