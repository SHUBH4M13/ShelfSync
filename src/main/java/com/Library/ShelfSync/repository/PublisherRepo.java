package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<PublisherEntity , Long>{
}
