package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.FinePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinePaymentRepo extends JpaRepository<FinePaymentEntity , Long> {
}
