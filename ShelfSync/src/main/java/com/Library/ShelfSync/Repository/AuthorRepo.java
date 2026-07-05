package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity , Long> {
}
