package com.nanoo.library.clientweb.proxies;

import com.nanoo.library.clientweb.beans.user.ClientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 23:08
 */
@FeignClient(name = "microservice-account", url = "localhost:9001")
public interface MManagementAccountProxy {

    @GetMapping("/clients")
    List<ClientBean> listAllClient();
    
}