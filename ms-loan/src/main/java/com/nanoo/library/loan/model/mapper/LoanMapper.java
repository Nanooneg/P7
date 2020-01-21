package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.LoanDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.model.entities.Loan;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:51
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoanMapper {
    
    LoanMapper MAPPER = Mappers.getMapper(LoanMapper.class);
    
    Loan fromDtoToLoan (LoanDto loanDto);
    
    @InheritInverseConfiguration
    LoanDto fromLoanToDto (Loan loan);
    
    //TODO check if possible to call for another class to map only one attribut
    @Mapping(source = "status.entitled", target = "status")
    LoanWithBookInfoDto fromLoanToDtoWithBookInfo(Loan loan);

}
