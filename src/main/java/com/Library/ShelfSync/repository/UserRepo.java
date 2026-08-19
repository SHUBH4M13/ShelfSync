package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity , Long> , JpaSpecificationExecutor<UserEntity> {
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String mail);

}
