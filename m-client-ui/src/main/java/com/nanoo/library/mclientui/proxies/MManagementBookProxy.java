package com.nanoo.library.mclientui.proxies;

import com.nanoo.library.mclientui.beans.book.BookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "microservice-book", url = "localhost:9002")
public interface MManagementBookProxy {
    
    @GetMapping("/livres")
    List<BookBean> listAllBook();
    
}
