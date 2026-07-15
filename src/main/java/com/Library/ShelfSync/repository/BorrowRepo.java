package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<BorrowEntity,Long> , JpaSpecificationExecutor<BorrowEntity> {
}
