package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<BorrowEntity,Long> {
}
