package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String mail);

    Page<UserEntity> findAll(Pageable pageable, Specification<UserEntity> spec);
}
