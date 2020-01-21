package com.nanoo.library.loan.database;

import com.nanoo.library.loan.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    
    List<Loan> findAllByAccountId(int userId);
    
}
