package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.AuthorRepository;
import com.nanoo.library.book.database.BookRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.BookInfoLoanDto;
import com.nanoo.library.book.model.dto.BookWithoutAuthorsAndLibraryDto;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.entities.Library;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.service.contractService.AuthorService;
import com.nanoo.library.book.service.contractService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:06
 */
@Service
public class BookServiceImpl implements BookService {
    
    private static final String TITLE_ATT = "title";
    private static final String AUTHOR_ATT = "author";
    private static final String REGISTRATION_ATT = "registration";
    
    private final BookRepository bookRepository;
    
    private final AuthorService authorService;
    
    private final BookMapper bookMapper;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookMapper = bookMapper;
    }
    
    @Override
    public List<BookDto> getBookList() {
        List<BookDto> bookDtos = new ArrayList<>();
        
        List<Book> books = bookRepository.findAll(Sort.by(TITLE_ATT));
        
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        return bookDtos;
    }
    
    @Override
    public List<BookDto> getLastRegisteredBook() {
        List<BookDto> bookDtos = new ArrayList<>();

        Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
        Page<Book> books = bookRepository.findAll(topFive);
    
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
    
        return bookDtos;
    }
    
    @Override
    public List<BookDto> getLastRegisteredBookOfLibrary(Library library) {
        List<BookDto> bookDtos = new ArrayList<>();
    
        Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
        Page<Book> books = bookRepository.findAllByLibrary(library,topFive);
    
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
    
        return bookDtos;
    }
    
    @Override
    public List<BookDto> getSearchResult(boolean available, String searchAttribut,
                                         String searchCriteria, String libraryId){
        
        List<BookDto> bookDtos = new ArrayList<>();
        
        String pSearchAttribut = "%" + searchAttribut + "%";
        List<Book> books;

        switch (searchCriteria){
            
            case TITLE_ATT :
                books = bookRepository.findBySearchAttributAndByLibrary(available, pSearchAttribut,Integer.parseInt(libraryId), Sort.by(TITLE_ATT));
                break;
            case AUTHOR_ATT :
                books = authorService.getAuthorBookFromSearchCriteria(available,searchAttribut,Integer.parseInt(libraryId));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + searchCriteria);
        }
    
        if (Integer.parseInt(libraryId) > 0){
            for (Book book : books){
                if (book.getLibrary().getId() != Integer.parseInt(libraryId)) {
                    books.remove(book);
                }
            }
        }
        
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        return bookDtos;
    
    }
    
    @Override
    public BookInfoLoanDto getBookInfo(int bookId) {
        BookInfoLoanDto bookDto = new BookInfoLoanDto();
        Optional<Book> book = bookRepository.findById(bookId);
        
        if (book.isPresent()){
            bookDto = bookMapper.fromBookToForLoanDto(book.get());
        }
        return bookDto;
    }
}
