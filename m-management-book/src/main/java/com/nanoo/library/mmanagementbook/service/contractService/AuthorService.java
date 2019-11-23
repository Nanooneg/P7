package com.nanoo.library.mmanagementbook.service.contractService;

import com.nanoo.library.mmanagementbook.model.dto.AuthorDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:04
 */
public interface AuthorService {
    
    List<AuthorDto> getAuthorList();
    
}
