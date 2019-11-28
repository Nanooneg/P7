package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.BookRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:06
 */
@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
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
    public BookDto getBook(int id){
        
        Optional<Book> book = bookRepository.findById(id);
    
        return book.map(bookMapper::fromBookToDto).orElse(null);
    
    }
}
