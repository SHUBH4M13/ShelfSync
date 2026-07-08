package com.Library.ShelfSync.dto;

public class PublisherRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublisherRequest(String name) {
        this.name = name;
    }
}
