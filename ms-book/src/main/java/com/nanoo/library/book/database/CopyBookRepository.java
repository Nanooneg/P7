package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.CopyBook;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 06/02/2020 - 21:40
 */
@Repository
public interface CopyBookRepository extends JpaRepository<CopyBook,Integer> {
    
    @Query(value = "SELECT distinct copy FROM CopyBook copy " +
                   "JOIN copy.library library " +
                   "JOIN copy.book book " +
                   "WHERE (book.title = :title )" +
                   "AND (:available = false OR copy.available = :available)" +
                   "AND (:idLibrary = 0 OR library.id = :idLibrary)")
    List<CopyBook> findByTitleSearchAttribut (@Param("title") String title,
                                              @Param("available") boolean available,
                                              @Param("idLibrary") int idLibrary);
    
    @Query(value = "SELECT distinct copy FROM CopyBook copy " +
                   "JOIN copy.library library " +
                   "JOIN copy.book book " +
                   "JOIN book.author author " +
                   "WHERE ((:author = '' OR LOWER(author.firstName) LIKE LOWER(:author))" +
                       "OR (:author = '' OR LOWER(author.lastName) LIKE LOWER(:author)))" +
                   "AND (:available = false OR copy.available = :available)" +
                   "AND (:idLibrary = 0 OR library.id = :idLibrary)")
    List<CopyBook> findByAuthorSearchAttribut (@Param("author") String author,
                                               @Param("available") boolean available,
                                               @Param("idLibrary") int idLibrary);
    
}
