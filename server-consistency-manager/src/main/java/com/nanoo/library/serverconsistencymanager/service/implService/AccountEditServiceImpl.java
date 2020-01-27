package com.nanoo.library.serverconsistencymanager.service.implService;

import com.nanoo.library.serverconsistencymanager.model.beans.user.ClientBean;
import com.nanoo.library.serverconsistencymanager.model.beans.user.UserBean;
import com.nanoo.library.serverconsistencymanager.service.contractService.AccountEditService;
import com.nanoo.library.serverconsistencymanager.web.proxy.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 27/01/2020 - 12:42
 */
@Service
public class AccountEditServiceImpl implements AccountEditService {
    
    private FeignProxy proxy;
    
    @Autowired
    public AccountEditServiceImpl(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @Override
    public void editAccount(@RequestHeader("Authorization") String accessToken, @RequestBody ClientBean clientBean){
        
        // TODO handle Exception
        proxy.editAccount(accessToken,clientBean);
        proxy.editCredentials(accessToken,new UserBean(clientBean.getEmail(),clientBean.getPassword()));
        proxy.editLoanAccount(accessToken,clientBean);
    
    }

}
