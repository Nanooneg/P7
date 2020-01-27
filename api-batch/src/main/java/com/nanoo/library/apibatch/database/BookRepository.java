package com.nanoo.library.apibatch.database;

import com.nanoo.library.apibatch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 27/01/2020 - 15:22
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
