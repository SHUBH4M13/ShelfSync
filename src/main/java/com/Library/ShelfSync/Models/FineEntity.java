package com.Library.ShelfSync.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "fine_rules")
public class FineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer maxBorrowDays;

    private Integer finePerDay;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
