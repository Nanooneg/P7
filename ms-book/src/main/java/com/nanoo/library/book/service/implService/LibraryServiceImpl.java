package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.LibraryRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.CopyBookDto;
import com.nanoo.library.book.model.dto.LibraryDto;
import com.nanoo.library.book.model.entities.CopyBook;
import com.nanoo.library.book.model.entities.Library;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.model.mapper.CopyBookMapper;
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
    private final CopyBookMapper copyBookMapper;
    
    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, LibraryMapper libraryMapper, BookMapper bookMapper, CopyBookMapper copyBookMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
        this.bookMapper = bookMapper;
        this.copyBookMapper = copyBookMapper;
    }
    @Override
    public List<LibraryDto> getLibraryList() {
        List<LibraryDto> libraryDtos = new ArrayList<>();
        
        List<Library> libraries = libraryRepository.findAll();
        
        for (Library library : libraries){
            libraryDtos.add(libraryMapper.fromLibraryToDto(library));
        }
        
        return libraryDtos;
    }
    
    @Override
    public Set<BookDto> getBookList(int libraryId) {
        Map<Integer,BookDto> bookDtos = new HashMap<>();
        List<CopyBook> copies = new ArrayList<>();
        
        Optional<Library> library = libraryRepository.findById(libraryId);
        if (library.isPresent()) {
            Library existLibrary = library.get();
            Set<CopyBook> libraryCopies = existLibrary.getCopies();
    
            for (CopyBook copy : libraryCopies) {
                bookDtos.put(copy.getBook().getId(),bookMapper.fromBookToDto(copy.getBook()));
                copies.add(copy);
            }
        }
        
            Set<BookDto> distinctBookDtos = new HashSet<>(bookDtos.values());
            
            for (BookDto bookDto : distinctBookDtos) {
                Set<CopyBookDto> bookCopies = new HashSet<>();
                
                bookDto.setCopies(null);
                for (CopyBook copyBook : copies){
                    if (copyBook.getBook().getId().equals(bookDto.getId()))
                        bookCopies.add(copyBookMapper.fromCopyBookToDto(copyBook));
                }
                bookDto.setCopies(bookCopies);
            }
            
        
        return distinctBookDtos;
    }
    
    @Override
    public Library findById(int libraryId) {
        
        return libraryRepository.findById(libraryId).orElse(null);
    
    }
}
