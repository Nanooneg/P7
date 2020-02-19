package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.service.contractService.BookService;
import com.nanoo.library.book.service.contractService.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
  public List<BookDto> listAllBooks() {
    
    return bookService.getBookList();
    
  }
  
  @GetMapping("/book-last")
  public List<BookDto> getLastRegisteredBook() {
    
    return bookService.getLastRegisteredBook();
    
  }
  
  @GetMapping("/search-result")
  @ResponseBody
  public List<BookDto> getSearchResult(
    @RequestParam(value = "available", required = false) boolean available,
    @RequestParam(value = "searchValue", required = false) String searchValue,
    @RequestParam(value = "searchCriteria", required = false) String searchCriteria,
    @RequestParam(value = "libraryId", required = false) String libraryId) {
    
      if (Integer.parseInt(libraryId) == 0) {
          return bookService.getSearchResult(available, searchValue, searchCriteria);
      } else {
          return libraryService.getSearchResultByLibrary(available, searchValue, searchCriteria,
            Integer.parseInt(libraryId));
      }
  }
  
  @GetMapping("{libraryId}/book/{bookId}")
  public BookDto getBookInfo(@PathVariable int bookId, @PathVariable int libraryId) {
    return bookService.getBookInfo(bookId,libraryId);
  }
  
}