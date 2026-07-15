package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.enums.RoleName;
import com.Library.ShelfSync.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepo extends JpaRepository<RoleEntity , Long> {

    boolean existsByRoleName(RoleName roleName);

    Optional<RoleEntity> findByRoleName(RoleName roleName);
}
