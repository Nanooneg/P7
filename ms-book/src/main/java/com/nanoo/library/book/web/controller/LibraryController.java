package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.LibraryWithoutBooksDto;
import com.nanoo.library.book.service.contractService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:26
 */
@RestController
@RequestMapping("/consult")
public class LibraryController {
    
    private final LibraryService libraryService;
    
    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    
    @GetMapping("/libraries")
    public List<LibraryWithoutBooksDto> listAllLibrary(){
        
        return libraryService.getLibraryList();
        
    }
    
    @GetMapping("/{library}/book-catalog")
    public List<BookDto> listAllBooksOfLibrary(@PathVariable String library){
        
        return libraryService.getBookList(Integer.parseInt(library));
        
    }
    
}
