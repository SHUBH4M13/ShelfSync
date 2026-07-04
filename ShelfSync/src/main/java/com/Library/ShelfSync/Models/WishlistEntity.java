package com.Library.ShelfSync.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "wishlist")
public class WishlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "student_id")
    private UserEntity student;

    @JoinColumn(name = "book_id")
    private BookEntity book;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
