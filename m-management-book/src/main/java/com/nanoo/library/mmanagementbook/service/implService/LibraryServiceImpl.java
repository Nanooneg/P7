package com.nanoo.library.mmanagementbook.service.implService;

import com.nanoo.library.mmanagementbook.database.LibraryRepository;
import com.nanoo.library.mmanagementbook.model.dto.LibraryWithoutBooksDto;
import com.nanoo.library.mmanagementbook.model.entities.Library;
import com.nanoo.library.mmanagementbook.model.mapper.LibraryMapper;
import com.nanoo.library.mmanagementbook.service.contractService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:16
 */
@Service
public class LibraryServiceImpl implements LibraryService {
    
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    
    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, LibraryMapper libraryMapper) {
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
    }
    
    @Override
    public List<LibraryWithoutBooksDto> getLibraryList() {
        List<LibraryWithoutBooksDto> libraryDtos = new ArrayList<>();
        
        List<Library> libraries = libraryRepository.findAll();
        
        for (Library library : libraries){
            libraryDtos.add(libraryMapper.fromLibraryToDtoWithoutBooks(library));
        }
        
        return libraryDtos;
    }
}
