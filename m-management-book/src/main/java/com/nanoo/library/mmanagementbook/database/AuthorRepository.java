package com.nanoo.library.mmanagementbook.database;

import com.nanoo.library.mmanagementbook.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:53
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
