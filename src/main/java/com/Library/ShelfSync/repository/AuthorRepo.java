package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity , Long> {
}
