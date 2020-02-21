package com.nanoo.library.book.service.implService;

import com.nanoo.library.book.database.BookRepository;
import com.nanoo.library.book.model.dto.BookDto;
import com.nanoo.library.book.model.dto.CopyBookDto;
import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.entities.Library;
import com.nanoo.library.book.model.mapper.BookMapper;
import com.nanoo.library.book.service.contractService.AuthorService;
import com.nanoo.library.book.service.contractService.BookService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:06
 */
@Service
public class BookServiceImpl implements BookService {
  
  private static final String TITLE_ATT = "title";
  private static final String AUTHOR_ATT = "author";
  private static final String REGISTRATION_ATT = "registration";
  private static final int DEFAULT_LIBRARY = 0;
  
  private final BookRepository bookRepository;
  
  private final AuthorService authorService;
  
  private final BookMapper bookMapper;
  
  @Autowired
  public BookServiceImpl(BookRepository bookRepository, AuthorService authorService,
    BookMapper bookMapper) {
    this.bookRepository = bookRepository;
    this.authorService = authorService;
    this.bookMapper = bookMapper;
  }
  
  @Override
  public List<BookDto> getBookList() {
    List<BookDto> bookDtos = new ArrayList<>();
    
    List<Book> books = bookRepository.findAll(Sort.by(TITLE_ATT));
    
    for (Book book : books) {
      bookDtos.add(bookMapper.fromBookToDto(book));
    }
    
    return getBookWitAvailableCopyBook(bookDtos,DEFAULT_LIBRARY);
  }
  
  
  @Override
  public List<BookDto> getLastRegisteredBook() {
    Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
    
    List<BookDto> bookDtos = bookMapper.fromBooksToDtos(bookRepository.findAll(topFive).toList());
    
    return getBookWitAvailableCopyBook(bookDtos,DEFAULT_LIBRARY);
  }
  
  @Override
  public List<BookDto> getSearchResult(boolean available, String searchAttribut,
    String searchCriteria) {
    
    // case user look for all available books
    if (available && searchAttribut.equalsIgnoreCase("")) {
      return getAvailableBookOfList(getBookList());
    }
    
    
    String pSearchAttribut = "%" + searchAttribut + "%";
    List<Book> books;
    
    switch (searchCriteria) {
      
      case TITLE_ATT:
        books = bookRepository.findBySearchAttribut(pSearchAttribut, Sort.by(TITLE_ATT));
        break;
      case AUTHOR_ATT:
        books = authorService.getAuthorBookFromSearchCriteria(searchAttribut);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + searchCriteria);
    }
    
    List<BookDto> bookDtos = bookMapper.fromBooksToDtos(books);
  
    if (available) {
      return getAvailableBookOfList(getBookWitAvailableCopyBook(bookDtos,DEFAULT_LIBRARY));
    } else {
      return getBookWitAvailableCopyBook(bookDtos,DEFAULT_LIBRARY);
    }
    
  }
  
  @Override
  public List<BookDto> getLastRegisteredBookOfLibrary(Library library) {
    Pageable topFive = PageRequest.of(0, 5, Sort.by(REGISTRATION_ATT));
  
    List<BookDto> bookDtos = bookMapper.fromBooksToDtos(
      bookRepository.findLastRegisteredByLibrary(library, topFive).toList());
    
    return getBookWitAvailableCopyBook(bookDtos,library.getId());
  }
  
  @Override
  public BookDto getBookInfo(int bookId, int libraryId) {
    Optional<Book> book = bookRepository.findById(bookId);
    BookDto bookDto = book.map(bookMapper::fromBookToDto).orElse(null);
  
    assert bookDto != null;
    
    if (libraryId != 0) {
      return getOnlyLibraryCopies(bookDto,libraryId);
    }
    
    return sortCopiesByLibrary(bookDto);
  }
  
  private BookDto getOnlyLibraryCopies(BookDto bookDto, int libraryId) {
    
    List<CopyBookDto> copyToRemove = new ArrayList<>();
    bookDto.getCopies().stream()
                       .filter(copyBookDto -> copyBookDto.getLibrary().getId() != libraryId)
                       .forEach(copyToRemove::add);
    bookDto.getCopies().removeAll(copyToRemove);
    
    return bookDto ;
  }
  
  private BookDto sortCopiesByLibrary(BookDto bookDto) {
    
    bookDto.getCopies().sort(Comparator.comparing(c -> c.getLibrary().getId()));
    
    return bookDto;
  }
  
  static List<BookDto> getBookWitAvailableCopyBook(List<BookDto> bookDtos, int libraryId) {
    
    for (BookDto book : bookDtos) {
      List<CopyBookDto> availableCopies = new ArrayList<>();
      
      for (CopyBookDto copyBook : book.getCopies()) {
        if (copyBook.isAvailable() && (libraryId == 0 || copyBook.getLibrary().getId() == libraryId)) {
          availableCopies.add(copyBook);
        }
      }
      
      book.setAvailableCopies(availableCopies.size());
    }
    
    return bookDtos;
  }
  
  static List<BookDto> getAvailableBookOfList(List<BookDto> bookDtoList) {
    List<BookDto> unAvailableBookDto = new ArrayList<>();
    
    for (BookDto bookDto : bookDtoList) {
      if (bookDto.getAvailableCopies() == 0) {
        unAvailableBookDto.add(bookDto);
      }
    }
    
    bookDtoList.removeAll(unAvailableBookDto);
    return bookDtoList;
  }
  
}
