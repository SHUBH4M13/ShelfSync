package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.FineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepo extends JpaRepository<FineEntity , Integer> {

}
