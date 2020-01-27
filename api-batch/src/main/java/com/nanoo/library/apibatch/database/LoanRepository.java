package com.nanoo.library.apibatch.database;

import com.nanoo.library.apibatch.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

}
