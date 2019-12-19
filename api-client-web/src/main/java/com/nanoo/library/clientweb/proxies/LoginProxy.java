package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author nanoo
 * @create 17/12/2019 - 15:44
 */
@FeignClient(name = "ms-authentication", url = "localhost:9100")
public interface LoginProxy {
    
    /* Login */
    @PostMapping("/auth/login")
    void authenticateClient(@RequestBody UserBean user);
    
}
