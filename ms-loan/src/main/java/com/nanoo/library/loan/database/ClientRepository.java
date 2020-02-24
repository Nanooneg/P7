package com.nanoo.library.loan.database;

import com.nanoo.library.loan.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 23/01/2020 - 13:03
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
