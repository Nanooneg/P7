package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.book.BookBean;
import com.nanoo.library.clientweb.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.beans.library.LibraryWithoutBookBean;
import com.nanoo.library.clientweb.beans.user.ClientBean;
import com.nanoo.library.clientweb.beans.user.UserBean;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "zuul-server", url = "localhost:8762") //TODO try to remove url (ms is register in zuul properties)
public interface BookProxy {
    
    /* Call for books list in all libraries */
    @GetMapping("/book/consult/book-catalog")
    List<BookBean> listAllBook();
    
    @GetMapping("/book/consult/book-last")
    List<BookBean> getLastRegisteredBook();
    
    @GetMapping("/book/consult/search-result")
    List<BookBean> listSearchResult(@SpringQueryMap BookSearchAttribut searchAttribut);
    
    
    /* Call for books list in a specific library */
    @GetMapping("/book/consult/{library}/book-catalog")
    List<BookBean> listAllBookOfLibrary(@PathVariable("library") String library);
    
    @GetMapping("/book/consult/{library}/book-last")
    List<BookBean> getLastRegisteredBookOfLibrary(@PathVariable("library") String library);
    
    
    /* Call for libraries list */
    @GetMapping("/book/consult/libraries")
    List<LibraryWithoutBookBean> listAllLibrary();
    
    
    /* Login */
    @PostMapping("/auth/login")
    void authenticateClient(@RequestBody UserBean user);
}
