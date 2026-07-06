package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<WishlistEntity , Long> {
}
