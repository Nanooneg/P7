package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.CopyBookDto;
import com.nanoo.library.loan.model.entities.CopyBook;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author nanoo
 * @create 07/02/2020 - 10:13
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {BookMapper.class})
public interface CopyBookMapper {
    
    CopyBook fromDtoToCopyBook (CopyBookDto copyBookDto);
    
    @InheritInverseConfiguration
    @Mapping(source = "condition.entitled", target = "condition")
    CopyBookDto fromCopyBookToDto (CopyBook copyBook);
    
    
}
