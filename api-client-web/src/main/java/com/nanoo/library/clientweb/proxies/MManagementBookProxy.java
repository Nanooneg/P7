package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.book.BookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "zuul-server", url = "localhost:8762")
public interface MManagementBookProxy {
    
    @GetMapping("/book/consult/book-catalog")
    List<BookBean> listAllBook();
    
    @GetMapping("/book/consult/book-detail/{id}")
    BookBean getBookDetail(@PathVariable("id") int id);
    
}
