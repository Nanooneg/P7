package com.nanoo.library.clientweb.web.proxy;

import com.nanoo.library.clientweb.model.beans.book.BookBean;
import com.nanoo.library.clientweb.model.beans.book.BookSearchAttribut;
import com.nanoo.library.clientweb.model.beans.library.LibraryWithoutBookBean;
import com.nanoo.library.clientweb.model.beans.loan.LoanBean;
import com.nanoo.library.clientweb.model.beans.user.AccountBean;
import com.nanoo.library.clientweb.model.beans.user.UserBean;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author nanoo
 * @create 24/11/2019 - 00:21
 */
@FeignClient(name = "server-gateway", url = "localhost:8763")
public interface FeignProxy {

    /* ================================ */
    /* === No Authentication needed === */
    /* ================================ */

    @GetMapping("/ms-book/consult/book-catalog")
    List<BookBean> listAllBook();

    @GetMapping("/ms-book/consult/book-last")
    List<BookBean> getLastRegisteredBook();

    @GetMapping("/ms-book/consult/search-result")
    List<BookBean> listSearchResult(@SpringQueryMap BookSearchAttribut searchAttribut);

    @GetMapping("/ms-book/consult/{library}/book-catalog")
    List<BookBean> listAllBookOfLibrary(@PathVariable("library") String library);

    @GetMapping("/ms-book/consult/{library}/book-last")
    List<BookBean> getLastRegisteredBookOfLibrary(@PathVariable("library") String library);

    @GetMapping("/ms-book/consult/libraries")
    List<LibraryWithoutBookBean> listAllLibrary();
    
    @GetMapping("/ms-book/consult/{libraryId}/book/{bookId}")
    BookBean getBookDetail(@PathVariable("bookId") int bookId,
                           @PathVariable("libraryId") int libraryId);
    
    @PostMapping("/ms-authentication/login")
    String doLogin(@RequestBody UserBean userBean);

    /* =============================== */
    /* ==== Authentication needed ==== */
    /* =============================== */

    @GetMapping("/ms-account/consult/user-info")
    AccountBean getAccountInfo(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken);

    @GetMapping("/ms-loan/consult/loans/{userId}/{loanProperty}")
    List<LoanBean> getUserLoanList(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken,
                                   @PathVariable("userId") int userId,
                                   @PathVariable("loanProperty") String loanProperty);

    @GetMapping("/ms-loan/edit/extend/loan/{loanId}")
    LoanBean extendLoanExpectedReturnDate(
        @RequestHeader(CommonSecurityConfig.HEADER) String accessToken,
        @PathVariable("loanId") int loanId);

    @PostMapping("/ms-consistency-manager/edit/account")
    AccountBean editAccount(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken,
                            @RequestBody AccountBean accountBean);

    @PostMapping("/ms-authentication/refresh")
    String doUpdateToken(@RequestHeader(CommonSecurityConfig.HEADER) String accessToken,
                         @RequestBody UserBean userUpdated);
  
}
