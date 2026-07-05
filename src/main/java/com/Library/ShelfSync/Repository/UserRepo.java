package com.Library.ShelfSync.Repository;

import com.Library.ShelfSync.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity , Long> {
}
