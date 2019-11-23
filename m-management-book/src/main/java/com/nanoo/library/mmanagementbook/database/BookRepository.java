package com.nanoo.library.mmanagementbook.database;

import com.nanoo.library.mmanagementbook.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:52
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
