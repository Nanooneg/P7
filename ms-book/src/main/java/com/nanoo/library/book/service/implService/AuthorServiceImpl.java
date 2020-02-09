package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.AuthorRepository;
import com.nanoo.library.book.model.entities.Author;
import com.nanoo.library.book.model.entities.Book;
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
    
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    
    @Override
    public List<Book> getAuthorBookFromSearchCriteria(String searchAttribut){
        List<Book> authorBooks = new ArrayList<>();
        String pSearchAttribut = "%" + searchAttribut + "%";
        
        List<Author> authors = authorRepository.findBySearchAttribut(pSearchAttribut);
        for (Author author : authors){
            authorBooks.addAll(author.getBooks());
        }
        
        return authorBooks;
    }
}
