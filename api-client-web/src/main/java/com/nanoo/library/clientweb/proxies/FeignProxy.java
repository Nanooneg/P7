package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.book.BookBean;
import com.nanoo.library.clientweb.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.beans.library.LibraryWithoutBookBean;
import com.nanoo.library.clientweb.beans.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {
    
    /* Call for books list in all libraries */
    @GetMapping("/ms-book/consult/book-catalog")
    List<BookBean> listAllBook();
    
    @GetMapping("/ms-book/consult/book-last")
    List<BookBean> getLastRegisteredBook();
    
    @GetMapping("/ms-book/consult/search-result")
    List<BookBean> listSearchResult(@SpringQueryMap BookSearchAttribut searchAttribut);
    
    /* Call for books list in a specific library */
    @GetMapping("/ms-book/consult/{library}/book-catalog")
    List<BookBean> listAllBookOfLibrary(@PathVariable("library") String library);
    
    @GetMapping("/ms-book/consult/{library}/book-last")
    List<BookBean> getLastRegisteredBookOfLibrary(@PathVariable("library") String library);
    
    /* =================================================================================== */
    
    /* Call for libraries list */
    @GetMapping("/ms-book/consult/libraries")
    List<LibraryWithoutBookBean> listAllLibrary();
    
    /* =================================================================================== */
    
    /* Login */
    @PostMapping("/ms-authentication/login")
    String doLogin (@RequestBody UserBean userBean);
    
}
