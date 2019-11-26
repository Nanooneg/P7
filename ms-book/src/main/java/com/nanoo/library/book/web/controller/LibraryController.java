package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.LibraryWithoutBooksDto;
import com.nanoo.library.book.service.contractService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:26
 */
@RestController
public class LibraryController {
    
    private final LibraryService libraryService;
    
    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    
    @GetMapping("/bibliotheques")
    public List<LibraryWithoutBooksDto> listAllLibrary(){
        
        return libraryService.getLibraryList();
        
    }
}
