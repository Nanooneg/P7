package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:52
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    
    @Query(value = "SELECT distinct b.* FROM book b " +
            "WHERE (:available = false OR b.available = :available)" +
            "AND (:title = '' OR LOWER(b.title) LIKE LOWER(:title) )",
            nativeQuery = true)
    List<Book> findBySearchAttribut(@Param("available") boolean available,
                                    @Param("title") String title);
    
    
}