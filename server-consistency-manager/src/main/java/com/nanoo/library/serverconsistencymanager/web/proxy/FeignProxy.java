package com.nanoo.library.serverconsistencymanager.web.proxy;

import com.nanoo.library.serverconsistencymanager.model.beans.user.ClientBean;
import com.nanoo.library.serverconsistencymanager.model.beans.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 24/01/2020 - 16:04
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {
    
    /* =============================== */
    /* ==== Authentication needed ==== */
    /* =============================== */
    
    @PostMapping("/ms-account/edit/account")
    HttpStatus editAccount(@RequestHeader("Authorization") String accessToken, @RequestBody ClientBean account);
    
    @PostMapping("/ms-authentication/edit/credential")
    HttpStatus editCredentials(@RequestHeader("Authorization") String accessToken, @RequestBody UserBean user);
    
    @PostMapping("/ms-loan/edit/account")
    HttpStatus editLoanAccount (@RequestHeader("Authorization") String accessToken, @RequestBody ClientBean account);
    
}
