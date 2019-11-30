package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.proxies.MManagementBookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:30
 */
@Controller
@RequestMapping("/livre")
public class BookController {
    
    private final MManagementBookProxy bookProxy;
    
    @Autowired
    public BookController(MManagementBookProxy bookProxy) {
        this.bookProxy = bookProxy;
    }
    
    @GetMapping("/catalogue")
    public String displayAllBooks(Model model){
        
        model.addAttribute("books",bookProxy.listAllBook());
        
        return "Catalog";
    }
    
    @GetMapping("/detail/{id}")
    public String displayDetailBook(@PathVariable int id, Model model){
        
        model.addAttribute("book",bookProxy.getBookDetail(id));
        
        return "Book";
    }
}
