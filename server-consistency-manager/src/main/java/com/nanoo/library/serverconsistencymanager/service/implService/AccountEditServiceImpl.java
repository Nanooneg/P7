package com.nanoo.library.serverconsistencymanager.service.implService;

import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import com.nanoo.library.serverconsistencymanager.model.beans.authentication.CredentialConsistencyManager;
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
    
    /**
     * This method receive a client with attribut(s) to update and do update in all ms
     * If an error happen, do rollback with client backup value
     *
     * @param userAccessToken token
     * @param clientBean client to save in different ms
     * @return client updated if success or null
     */
    @Override
    public ClientBean editAccount(@RequestHeader(CommonSecurityConfig.HEADER) String userAccessToken,
                                  @RequestBody ClientBean clientBean){
        
        ClientBean backupAccountInfo = proxy.getAccountInfo(userAccessToken);
        String technicalAccessToken = proxy.doLogin(userAccessToken, new CredentialConsistencyManager());
        
        ClientBean msAccountClientModified;
        ClientBean msLoanClientModified;
        UserBean msAuthenticationUserModified;
        
        msAccountClientModified = proxy.editAccount(technicalAccessToken,clientBean);
        
        if (msAccountClientModified == null) {
            doRollBack(technicalAccessToken,backupAccountInfo);
            return null;
        }
        
        UserBean newUserInfo = new UserBean();
        newUserInfo.setUsername(clientBean.getEmail());
        newUserInfo.setPassword(clientBean.getPassword());
        newUserInfo.setId(clientBean.getId());
        msAuthenticationUserModified = proxy.editCredentials(technicalAccessToken,newUserInfo);
    
        if (!msAuthenticationUserModified.getUsername().equals(clientBean.getEmail())){
            doRollBack(technicalAccessToken,backupAccountInfo);
            return null;
        }
        
        msLoanClientModified = proxy.editLoanAccount(technicalAccessToken,clientBean);
    
        if (msLoanClientModified == null) {
            doRollBack(technicalAccessToken,backupAccountInfo);
            return null;
        }
        
        return msAccountClientModified;
    }
    
    /**
     * Manual rollback. get original db state with backup client value
     *
     * @param accessToken token
     * @param backup client backup
     */
    private void doRollBack(String accessToken, ClientBean backup){
        UserBean backUpUserInfo = new UserBean();
        backUpUserInfo.setUsername(backup.getEmail());
        backUpUserInfo.setPassword(backup.getPassword());
        backUpUserInfo.setId(backup.getId());
        
        proxy.editAccount(accessToken,backup);
        proxy.editCredentials(accessToken,backUpUserInfo);
        proxy.editLoanAccount(accessToken,backup);
    }

}
