package com.nanoo.library.serverconsistencymanager.web.proxy;

import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import com.nanoo.library.serverconsistencymanager.model.beans.user.ClientBean;
import com.nanoo.library.serverconsistencymanager.model.beans.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author nanoo
 * @create 24/01/2020 - 16:04
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {
    
    /* =============================== */
    /* ==== Authentication needed ==== */
    /* =============================== */
    
    @GetMapping("/ms-account/consult/user-info")
    ClientBean getAccountInfo(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken);
    
    @PutMapping("/ms-account/edit/account")
    ClientBean editAccount(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken, @RequestBody ClientBean account);
    
    @PutMapping("/ms-authentication/edit/credential")
    UserBean editCredentials(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken, @RequestBody UserBean user);
    
    @PutMapping("/ms-loan/edit/account")
    ClientBean editLoanAccount (@RequestHeader(CommonSecurityConfig.HEADER) String accessToken, @RequestBody ClientBean account);
}
