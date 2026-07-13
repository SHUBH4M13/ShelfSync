package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity , Long> {
    boolean existsByName(String name);

    Optional<AuthorEntity> findByName(String authorName);
}
