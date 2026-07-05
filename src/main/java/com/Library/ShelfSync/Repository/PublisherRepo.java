package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<PublisherEntity , Long>{
}
