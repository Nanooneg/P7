package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.proxies.MManagementBookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:30
 */
@Controller
public class BookController {
    
    private final MManagementBookProxy bookProxy;
    
    @Autowired
    public BookController(MManagementBookProxy bookProxy) {
        this.bookProxy = bookProxy;
    }
    
    @GetMapping("/livres")
    public String displayAllBooks(Model model){
        
        //TODO can't access to author in BookBean
        model.addAttribute("books",bookProxy.listAllBook());
        
        return "Book";
    }
    
}
