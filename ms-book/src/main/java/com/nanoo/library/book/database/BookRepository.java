package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.Book;
import com.nanoo.library.book.model.entities.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    
    @Query(value = "SELECT distinct b FROM Book b " +
                   "WHERE (:title = '' OR LOWER(b.title) LIKE LOWER(:title))")
    List<Book> findBySearchAttribut(@Param("title") String title, Sort sort);

    @Query(value = "SELECT distinct b FROM Book b " +
                   "INNER JOIN b.copies copy " +
                   "WHERE copy.library = :library")
    Page<Book> findLastRegisteredByLibrary(@Param("library") Library library, Pageable pageable);
    
}