package com.nanoo.library.book.web.controller;

import com.nanoo.library.book.model.dto.AuthorDto;
import com.nanoo.library.book.service.contractService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:24
 */
@RestController
public class AuthorController {
    
    private final AuthorService authorService;
    
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @GetMapping("/auteurs")
    public List<AuthorDto> listAllAuthor(){
        
        return authorService.getAuthorList();
        
    }
}
