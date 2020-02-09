package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.BookRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.CopyBookDto;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.entities.CopyBook;
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

import java.util.ArrayList;
import java.util.List;

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
        
        return getBookWitAvailableCopyAccount(bookDtos);
    }
    
    
    @Override
    public List<BookDto> getLastRegisteredBook() {
        List<BookDto> bookDtos = new ArrayList<>();

        Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
        Page<Book> books = bookRepository.findAll(topFive);
    
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
    
        return getBookWitAvailableCopyAccount(bookDtos);
    }
    
    @Override
    public List<BookDto> getSearchResult(boolean available, String searchAttribut, String searchCriteria){
        
        // case user look for all available books
        if (available && searchAttribut.equalsIgnoreCase(""))
            return getAvailableBookOfList(getBookList());
        
        List<BookDto> bookDtos = new ArrayList<>();
        
        String pSearchAttribut = "%" + searchAttribut + "%";
        List<Book> books;

        switch (searchCriteria){
            
            case TITLE_ATT :
                books = bookRepository.findBySearchAttribut(pSearchAttribut, Sort.by(TITLE_ATT));
                break;
            case AUTHOR_ATT :
                books = authorService.getAuthorBookFromSearchCriteria(searchAttribut);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + searchCriteria);
        }
        
        for (Book book : books) {
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        if (available)
            return getAvailableBookOfList(getBookWitAvailableCopyAccount(bookDtos));
        else
            return getBookWitAvailableCopyAccount(bookDtos);
        
    }
    
    @Override
    public List<BookDto> getLastRegisteredBookOfLibrary(Library library) {
        List<BookDto> bookDtos = new ArrayList<>();
        
        Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
        Page<Book> books = bookRepository.findLastRegisteredByLibrary(library,topFive);
        
        for (Book book : books){
            bookDtos.add(bookMapper.fromBookToDto(book));
        }
        
        return getBookWitAvailableCopyAccount(bookDtos);
    }
    
    /*@Override
    public BookInfoLoanDto getBookInfo(int bookId) {
        BookInfoLoanDto bookDto = new BookInfoLoanDto();
        Optional<Book> book = bookRepository.findById(bookId);
        
        if (book.isPresent()){
            bookDto = bookMapper.fromBookToForLoanDto(book.get());
        }
        return bookDto;
    }*/
    
    static List<BookDto> getBookWitAvailableCopyAccount(List<BookDto> bookDtos) {
        
        for (BookDto book : bookDtos){
            List<CopyBookDto> availableCopies = new ArrayList<>();
    
            for (CopyBookDto copyBook : book.getCopies()){
                if (copyBook.isAvailable())
                    availableCopies.add(copyBook);
            }
    
            book.setAvailableCopies(availableCopies.size());
        }
        
        return bookDtos;
    }
    
    static List<BookDto> getAvailableBookOfList(List<BookDto> bookDtoList) {
        List<BookDto> unAvailableBookDto = new ArrayList<>();
        
        for (BookDto bookDto : bookDtoList){
            if (bookDto.getAvailableCopies() == 0) {
                unAvailableBookDto.add(bookDto);
            }
        }
        
        bookDtoList.removeAll(unAvailableBookDto);
        return bookDtoList;
    }
    
}
