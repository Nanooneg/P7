package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.book.BookBean;
import com.nanoo.library.clientweb.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.beans.library.LibraryWithoutBookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "zuul-server", url = "localhost:8762")
public interface MicroServicesProxy {
    
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
}
