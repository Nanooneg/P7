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
    
   /* @Query(value = "SELECT distinct a FROM Author a " +
            "WHERE (:author = '' OR LOWER(a.firstName) LIKE LOWER(:author))" +
            "OR (:author = '' OR LOWER(a.lastName) LIKE LOWER(:author))")
    List<Author> findBySearchAttribut(@Param("author") String author);*/
    
}
