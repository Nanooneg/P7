package com.nanoo.library.account.database;

import com.nanoo.library.account.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:48
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
