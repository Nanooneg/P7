package com.nanoo.library.mmanagementaccount.database;

import com.nanoo.library.mmanagementaccount.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:48
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
