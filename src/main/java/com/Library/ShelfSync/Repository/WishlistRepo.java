package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<WishlistEntity , Long> {
}
