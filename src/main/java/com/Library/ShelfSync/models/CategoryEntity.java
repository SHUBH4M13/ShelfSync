package com.Library.ShelfSync.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 50 , unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    public CategoryEntity() {
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
