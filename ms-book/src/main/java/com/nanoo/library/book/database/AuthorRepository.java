package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:53
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    
    @Query(value = "SELECT distinct a.* FROM author a " +
            "WHERE (:author = '' OR LOWER(a.first_name) LIKE LOWER(:author) )" +
            "OR (:author = '' OR LOWER(a.last_name) LIKE LOWER(:author) )",
            nativeQuery = true)
    List<Author> findBySearchAttribut(@Param("author") String author);
    
}
