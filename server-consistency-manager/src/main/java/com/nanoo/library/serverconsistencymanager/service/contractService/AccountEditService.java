package com.nanoo.library.serverconsistencymanager.service.contractService;

import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import com.nanoo.library.serverconsistencymanager.model.beans.user.ClientBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 27/01/2020 - 12:42
 */
public interface AccountEditService {
    
    ClientBean editAccount (@RequestHeader(CommonSecurityConfig.HEADER) String accessToken, @RequestBody ClientBean clientBean);
    
}
