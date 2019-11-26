package com.nanoo.library.book.database;

import com.nanoo.library.book.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:54
 */
@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {
}
