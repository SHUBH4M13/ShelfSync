package com.Library.ShelfSync.dto;

public class CategoryRequest {
    public String getName() {
        return name;
    }

    public CategoryRequest(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
