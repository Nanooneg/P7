package com.nanoo.library.loan.database;

import com.nanoo.library.loan.model.entities.Client;
import com.nanoo.library.loan.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 23/01/2020 - 13:03
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
    @Query(value = "SELECT client.loans FROM Client client WHERE client.id = :clientId")
    List<Loan> findAllLoanByClientId (@Param("clientId") int clientId);
    
}
