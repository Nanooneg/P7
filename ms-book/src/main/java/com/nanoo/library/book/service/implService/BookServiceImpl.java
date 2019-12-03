package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.AuthorRepository;
import com.nanoo.library.book.database.BookRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.entities.Author;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:06
 */
@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }
    
    @Override
    public List<BookDto> getBookList() {
        List<BookDto> bookDtos = new ArrayList<>();
        
        List<Book> books = bookRepository.findAll();
        
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        return bookDtos;
    }
    
    @Override
    public List<BookDto> getSearchResult(boolean available, String searchAttribut, String searchCriteria){
    
        List<BookDto> bookDtos = new ArrayList<>();
        
        String pSearch = "%" + searchAttribut + "%";
        List<Book> books = new ArrayList<>();

        switch (searchCriteria){
            
            case "title" :
                books = bookRepository.findBySearchAttribut(available,pSearch);
                break;
            case "author" :
                List<Author> authors = authorRepository.findBySearchAttribut(pSearch);
                for (Author author1 : authors){
                    if (available){
                        books.addAll(author1.getAvailableBooks());
                    }else {
                        books.addAll(author1.getBooks());
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + searchCriteria);
        }
    
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        return bookDtos;
    
    }
    
    @Override
    public BookDto getBook(int id){
        
        Optional<Book> book = bookRepository.findById(id);
    
        return book.map(bookMapper::fromBookToDto).orElse(null);
    
    }
    
}
