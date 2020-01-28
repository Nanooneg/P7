package com.nanoo.library.loan.database;

import com.nanoo.library.commonpackage.model.Status;
import com.nanoo.library.loan.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    
    @Query(value = "SELECT l FROM Loan l " +
                   "WHERE l.status = :status " +
                   "AND l.expectedReturnDate < CURRENT_DATE ")
    List<Loan> findAllByStatusAndReturnDate(@Param("status") Status ongoing);
}
