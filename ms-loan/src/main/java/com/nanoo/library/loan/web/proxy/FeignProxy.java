package com.nanoo.library.loan.web.proxy;

import com.nanoo.library.loan.model.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 21/01/2020 - 11:33
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {
    
    /* =============================== */
    /* ==== Authentication needed ==== */
    /* =============================== */
    
    @GetMapping("/ms-book/consult/book/{bookId}")
    BookDto getBookInfo(@RequestHeader("Authorization") String accessToken, @PathVariable int bookId);
    
}