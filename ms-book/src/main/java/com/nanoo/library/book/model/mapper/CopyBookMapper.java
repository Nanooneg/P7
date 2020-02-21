package com.nanoo.library.book.model.mapper;

import com.nanoo.library.book.model.dto.CopyBookDto;
import com.nanoo.library.book.model.entities.CopyBook;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 06/02/2020 - 12:12
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookMapper.class, LibraryMapper.class, AuthorMapper.class})
public interface CopyBookMapper {
    
    CopyBookMapper MAPPER = Mappers.getMapper(CopyBookMapper.class);
    
    @Mappings({
            @Mapping(source = "condition.entitled", target = "condition")
    })
    CopyBookDto fromCopyBookToDto (CopyBook copyBook);
    
    @InheritInverseConfiguration
    CopyBook fromDtoToCopyBook (CopyBookDto copyBookDto);
    
    List<CopyBookDto> fromCopiesToDtos (List<CopyBook> copies);
    
    List<CopyBook> fromDtosToCopies (List<CopyBookDto> copyBookDtos);
    
}
