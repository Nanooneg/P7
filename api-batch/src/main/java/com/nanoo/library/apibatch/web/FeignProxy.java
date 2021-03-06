package com.nanoo.library.apibatch.web;

import com.nanoo.library.apibatch.authentication.CredentialBatch;
import java.util.Date;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 27/01/2020 - 22:38
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {
    
    /* ================================ */
    /* === No Authentication needed === */
    /* ================================ */
    
    @PostMapping("/ms-authentication/login")
    String doLogin (@RequestBody CredentialBatch credentialBatch);
    
    /* =============================== */
    /* ==== Authentication needed ==== */
    /* =============================== */
    
    @GetMapping("/ms-loan/edit/loanStatus")
    int doLoanStatusUpdate(@RequestHeader("Authorization") String accessToken);
    
    @GetMapping("/ms-loan/get/emails")
    Map<String,Date> getOutdatedLoanEmails(@RequestHeader("Authorization") String accessToken);
    
}
