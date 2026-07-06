package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.FineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepo extends JpaRepository<FineEntity , Integer> {

}
