package com.nanoo.library.account.database;

import com.nanoo.library.account.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 22/11/2019 - 11:27
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
