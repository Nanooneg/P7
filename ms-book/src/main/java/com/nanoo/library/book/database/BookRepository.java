package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.Book;
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
    
    /*Page<Book> findAllByLibrary(Library library, Pageable pageable);*/
    
    @Query(value = "SELECT distinct b FROM Book b " +
            "WHERE (:title = '' OR LOWER(b.title) LIKE LOWER(:title))")
    List<Book> findBySearchAttribut(@Param("title") String title, Sort sort);

}