package com.nanoo.library.loan.model.mapper;

import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
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
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {BookMapper.class,ClientMapper.class})
public interface LoanMapper {
    
    LoanMapper MAPPER = Mappers.getMapper(LoanMapper.class);
    
    Loan fromDtoWithAccountInfoToLoan (LoanWithAccountInfoDto loanWithAccountInfoDto);
    Loan fromDtoWithBookInfoToLoan (LoanWithBookInfoDto loanWithBookInfoDto);
    
    @InheritInverseConfiguration
    LoanWithAccountInfoDto fromLoanToDtoWithAccountInfo (Loan loan);
    @Mapping(source = "status.entitled", target = "status")
    LoanWithBookInfoDto fromLoanToDtoWithBookInfo(Loan loan);

}
