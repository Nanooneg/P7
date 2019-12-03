package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.proxies.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:30
 */
@Controller
@RequestMapping("/livre")
public class BookController {
    
    private final BookProxy bookProxy;
    
    @Autowired
    public BookController(BookProxy bookProxy) {
        this.bookProxy = bookProxy;
    }
    
    @GetMapping("/catalogue")
    public String displayAllBooks(Model model){
        
        model.addAttribute("books",bookProxy.listAllBook());
        model.addAttribute("searchAttribut",new BookSearchAttribut());
        
        return "Catalog";
    }
    
    @PostMapping("/catalogue/search")
    public String displaySearchResult(@ModelAttribute("searchAttribut") BookSearchAttribut searchAttribut,
                                      Model model){
        
        model.addAttribute("books",bookProxy.listSearchResult(searchAttribut)); //TODO send search result and disable slider
        model.addAttribute("searchAttribut",searchAttribut);
    
        return "Catalog";
    }
    
    //TODO maybe not necessary
    @GetMapping("/detail/{id}")
    public String displayDetailBook(@PathVariable int id, Model model){
        
        model.addAttribute("book",bookProxy.getBookDetail(id));
        
        return "Book";
    }
    
    
}
