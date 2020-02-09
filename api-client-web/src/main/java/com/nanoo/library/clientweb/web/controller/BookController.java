package com.nanoo.library.clientweb.web.controller;

import com.nanoo.library.clientweb.model.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.model.beans.library.LibraryWithoutBookBean;
import com.nanoo.library.clientweb.web.proxy.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:30
 */
@Controller
@RequestMapping("/livre")
public class BookController {
    
    private static final String SLIDER_ATT = "sliderBooks";
    private static final String LIST_ATT = "books";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String LIBRARY_ATT = "libraries";
    private static final String ACTUAL_LIBRARY_ATT = "actualLibrary";
    
    private static final String CATALOG_VIEW = "catalog";
    
    private final FeignProxy proxy;
    
    @Autowired
    public BookController(FeignProxy bookProxy) {
        this.proxy = bookProxy;
    }
    
  
    @GetMapping("/catalogue")
    public String displayAllBooks(Model model) {
        
        model.addAttribute(SLIDER_ATT,proxy.getLastRegisteredBook());
        model.addAttribute(LIST_ATT,proxy.listAllBook());
        
        model.addAttribute(LIBRARY_ATT,proxy.listAllLibrary());
        model.addAttribute(SEARCH_ATT,new BookSearchAttribut());
        
        return CATALOG_VIEW;
    }
    
    @GetMapping("/{library}/catalogue")
    public String displayAllBooksOfLibrary(Model model, @PathVariable("library") String library){
        List<LibraryWithoutBookBean> libraries = proxy.listAllLibrary();
        LibraryWithoutBookBean actualLibrary = libraries.stream()
                .filter(libraryToFind -> Integer.parseInt(library)  == libraryToFind.getId())
                .findAny()
                .orElse(null);
        
        BookSearchAttribut searchAttribut = new BookSearchAttribut();
        searchAttribut.setLibraryId(Integer.parseInt(library));
        
        assert actualLibrary != null;
        model.addAttribute(SLIDER_ATT,proxy.getLastRegisteredBookOfLibrary(actualLibrary.getId().toString()));
        model.addAttribute(LIST_ATT,proxy.listAllBookOfLibrary(actualLibrary.getId().toString()));
    
        model.addAttribute(LIBRARY_ATT,libraries);
        model.addAttribute(SEARCH_ATT,searchAttribut);
    
        model.addAttribute(ACTUAL_LIBRARY_ATT, actualLibrary);
    
        return CATALOG_VIEW;
    }
    
    @PostMapping("/catalogue/search")
    public String displaySearchResult(@ModelAttribute("searchAttribut") BookSearchAttribut searchAttribut, Model model){
        List<LibraryWithoutBookBean> libraries = proxy.listAllLibrary();
        LibraryWithoutBookBean actualLibrary = libraries.stream()
                .filter(libraryToFind -> searchAttribut.getLibraryId()  == libraryToFind.getId())
                .findAny()
                .orElse(null);
        
        model.addAttribute(SLIDER_ATT,proxy.listSearchResult(searchAttribut));
        model.addAttribute(LIST_ATT,proxy.listSearchResult(searchAttribut));
    
        model.addAttribute(LIBRARY_ATT,libraries);
        model.addAttribute(SEARCH_ATT,searchAttribut);
        
        if (actualLibrary != null) {
            model.addAttribute(ACTUAL_LIBRARY_ATT, actualLibrary);
        }
    
        return CATALOG_VIEW;
    }

}
