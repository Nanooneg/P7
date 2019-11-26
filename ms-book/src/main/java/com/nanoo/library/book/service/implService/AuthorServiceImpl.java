package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.AuthorRepository;
import com.nanoo.library.book.model.dto.AuthorDto;
import com.nanoo.library.book.model.entities.Author;
import com.nanoo.library.book.model.mapper.AuthorMapper;
import com.nanoo.library.book.service.contractService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:12
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }
    
    @Override
    public List<AuthorDto> getAuthorList() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        
        List<Author> authors = authorRepository.findAll();
        
        for (Author author : authors){
            authorDtos.add(authorMapper.fromAuthorToDto(author));
        }
        
        return authorDtos;
    }
}
