package com.Library.ShelfSync.repository;

import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.models.WishlistEntity;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<WishlistEntity , Long> {

    List<WishlistEntity> findByStudent(UserEntity student);

}
