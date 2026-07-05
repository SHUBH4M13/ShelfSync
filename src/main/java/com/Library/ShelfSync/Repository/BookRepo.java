package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity,Long> {
}
