package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.CopyBookRepository;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:16
 */
@Service
public class LibraryServiceImpl implements LibraryService {
  
  private static final String TITLE_ATT = "title";
  private static final String AUTHOR_ATT = "author";
  
  private final LibraryRepository libraryRepository;
  private final CopyBookRepository copyBookRepository;
  private final LibraryMapper libraryMapper;
  private final BookMapper bookMapper;
  private final CopyBookMapper copyBookMapper;
  
  @Autowired
  public LibraryServiceImpl(LibraryRepository libraryRepository,
    CopyBookRepository copyBookRepository, LibraryMapper libraryMapper, BookMapper bookMapper,
    CopyBookMapper copyBookMapper) {
    this.libraryRepository = libraryRepository;
    this.copyBookRepository = copyBookRepository;
    this.libraryMapper = libraryMapper;
    this.bookMapper = bookMapper;
    this.copyBookMapper = copyBookMapper;
  }
  
  @Override
  public List<LibraryDto> getLibraryList() {
    List<LibraryDto> libraryDtos = new ArrayList<>();
    
    List<Library> libraries = libraryRepository.findAll();
    
    for (Library library : libraries) {
      libraryDtos.add(libraryMapper.fromLibraryToDto(library));
    }
    
    return libraryDtos;
  }
  
  @Override
  public List<BookDto> getBookList(int libraryId) {
    Map<Integer, BookDto> bookDtos = new HashMap<>();
    List<CopyBook> copies = new ArrayList<>();
    
    Optional<Library> library = libraryRepository.findById(libraryId);
    if (library.isPresent()) {
      Library existLibrary = library.get();
      Set<CopyBook> libraryCopies = existLibrary.getCopies();
      
      for (CopyBook copy : libraryCopies) {
        bookDtos.put(copy.getBook().getId(), bookMapper.fromBookToDto(copy.getBook()));
        copies.add(copy);
      }
    }
    
    List<BookDto> distinctBookDtos = new ArrayList<>(bookDtos.values());
    
    for (BookDto bookDto : distinctBookDtos) {
      List<CopyBookDto> bookCopies = new ArrayList<>();
      
      bookDto.setCopies(null);
      for (CopyBook copyBook : copies) {
          if (copyBook.getBook().getId().equals(bookDto.getId())) {
              bookCopies.add(copyBookMapper.fromCopyBookToDto(copyBook));
          }
      }
      bookDto.setCopies(bookCopies);
    }
    
    return BookServiceImpl.getBookWitAvailableCopyBook(distinctBookDtos,libraryId);
  }
  
  @Override
  public List<BookDto> getSearchResultByLibrary(boolean available, String searchAttribut,
    String searchCriteria, int libraryId) {
    
    // case user look for all available books
    if (available && searchAttribut.equalsIgnoreCase("")) {
      return BookServiceImpl.getAvailableBookOfList(getBookList(libraryId));
    }
    
    String pSearchAttribut = "%" + searchAttribut + "%";
    List<CopyBook> copyBooks;
    Map<Integer, BookDto> bookDtoMap = new HashMap<>();
    
    switch (searchCriteria) {
      
      case TITLE_ATT:
        copyBooks = copyBookRepository
          .findByTitleSearchAttribut(pSearchAttribut, available, libraryId);
        break;
      case AUTHOR_ATT:
        copyBooks = copyBookRepository
          .findByAuthorSearchAttribut(pSearchAttribut, available, libraryId);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + searchCriteria);
    }
    
    for (CopyBook copy : copyBooks) {
      bookDtoMap.put(copy.getBook().getId(), bookMapper.fromBookToDto(copy.getBook()));
    }
    
    Set<BookDto> distinctBookDtos = new HashSet<>(bookDtoMap.values());
    List<BookDto> bookDtos = new ArrayList<>(distinctBookDtos);
    
    return BookServiceImpl.getBookWitAvailableCopyBook(bookDtos,libraryId);
  }
  
  @Override
  public Library findById(int libraryId) {
    
    return libraryRepository.findById(libraryId).orElse(null);
    
  }
}
