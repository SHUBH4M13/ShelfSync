package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity,Long> , JpaSpecificationExecutor<BookEntity> {
    Optional<BookEntity> findById(Long id);

    boolean existsByIsbn(String isbn);
}
