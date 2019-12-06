package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.LibraryRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.LibraryWithoutBooksDto;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.entities.Library;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.model.mapper.LibraryMapper;
import com.nanoo.library.book.service.contractService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:16
 */
@Service
public class LibraryServiceImpl implements LibraryService {
    
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final BookMapper bookMapper;
    
    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, LibraryMapper libraryMapper, BookMapper bookMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
        this.bookMapper = bookMapper;
    }
    
    @Override
    public List<LibraryWithoutBooksDto> getLibraryList() {
        List<LibraryWithoutBooksDto> libraryDtos = new ArrayList<>();
        
        List<Library> libraries = libraryRepository.findAll();
        
        for (Library library : libraries){
            libraryDtos.add(libraryMapper.fromLibraryToDtoWithoutBooks(library));
        }
        
        return libraryDtos;
    }
    
    @Override
    public List<BookDto> getBookList(int library) {
        List<BookDto> bookDtos = new ArrayList<>();
        
        Optional<Library> library1 = libraryRepository.findById(library);
        if (library1.isPresent()){
            Library existLibrary = library1.get();
            Set<Book> libraryBooks = existLibrary.getBooks();
            
            for (Book book : libraryBooks){
                bookDtos.add(bookMapper.fromBookToDto(book));
            }
        }
        
        return bookDtos;
    }
    
    @Override
    public Library findById(int libraryId) {
        
        return libraryRepository.findById(libraryId).orElse(null);
    
    }
}
