package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.beans.library.LibraryWithoutBookBean;
import com.nanoo.library.clientweb.proxies.FeignProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
    private final FeignProxy bookProxy;
    
    @Autowired
    public BookController(FeignProxy bookProxy) {
        this.bookProxy = bookProxy;
    }
    
  
    @GetMapping("/catalogue")
    public String displayAllBooks(Model model, HttpServletRequest request, HttpServletResponse response) {
        
        model.addAttribute(SLIDER_ATT,bookProxy.getLastRegisteredBook());
        model.addAttribute(LIST_ATT,bookProxy.listAllBook());
        
        model.addAttribute(LIBRARY_ATT,bookProxy.listAllLibrary());
        model.addAttribute(SEARCH_ATT,new BookSearchAttribut());
        
        return CATALOG_VIEW;
    }
    
    @GetMapping("/{library}/catalogue")
    public String displayAllBooksOfLibrary(Model model, @PathVariable("library") String library){
        List<LibraryWithoutBookBean> libraries = bookProxy.listAllLibrary();
        LibraryWithoutBookBean actualLibrary = libraries.stream()
                .filter(libraryToFind -> Integer.parseInt(library)  == libraryToFind.getId())
                .findAny()
                .orElse(null);
        
        BookSearchAttribut searchAttribut = new BookSearchAttribut();
        searchAttribut.setLibraryId(Integer.parseInt(library));
        
        model.addAttribute(SLIDER_ATT,bookProxy.getLastRegisteredBookOfLibrary(actualLibrary.getId().toString()));
        model.addAttribute(LIST_ATT,bookProxy.listAllBookOfLibrary(actualLibrary.getId().toString()));
    
        model.addAttribute(LIBRARY_ATT,libraries);
        model.addAttribute(SEARCH_ATT,searchAttribut);
    
        model.addAttribute(ACTUAL_LIBRARY_ATT, actualLibrary);
    
        return CATALOG_VIEW;
    }
    
    @PostMapping("/catalogue/search")
    public String displaySearchResult(@ModelAttribute("searchAttribut") BookSearchAttribut searchAttribut, Model model){
        List<LibraryWithoutBookBean> libraries = bookProxy.listAllLibrary();
        LibraryWithoutBookBean actualLibrary = libraries.stream()
                .filter(libraryToFind -> searchAttribut.getLibraryId()  == libraryToFind.getId())
                .findAny()
                .orElse(null);
    
        System.out.println(searchAttribut);
        
        model.addAttribute(SLIDER_ATT,bookProxy.listSearchResult(searchAttribut));
        model.addAttribute(LIST_ATT,bookProxy.listSearchResult(searchAttribut));
    
        model.addAttribute(LIBRARY_ATT,libraries);
        model.addAttribute(SEARCH_ATT,searchAttribut);
    
        if (actualLibrary != null) {
            model.addAttribute(ACTUAL_LIBRARY_ATT, actualLibrary);
        }
    
        return CATALOG_VIEW;
    }

}
