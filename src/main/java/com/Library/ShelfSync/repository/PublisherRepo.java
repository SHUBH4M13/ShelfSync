package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepo extends JpaRepository<PublisherEntity , Long>{
    boolean existsByName(String name);

    Optional<PublisherEntity> findByName(String publisherName);
}
