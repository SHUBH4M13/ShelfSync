package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity , Long> {

}
