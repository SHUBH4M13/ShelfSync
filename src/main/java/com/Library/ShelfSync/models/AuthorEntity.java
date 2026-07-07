package com.Library.ShelfSync.models;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 100 , unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public AuthorEntity(String name) {
        this.name = name;
    }

    public AuthorEntity() {
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
