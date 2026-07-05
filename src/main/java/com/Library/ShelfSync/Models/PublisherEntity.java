package com.Library.ShelfSync.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 50 , unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public PublisherEntity(String name) {
        this.name = name;
    }

    public PublisherEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
