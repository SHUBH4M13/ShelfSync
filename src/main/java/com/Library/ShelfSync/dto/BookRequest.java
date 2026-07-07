package com.Library.ShelfSync.dto;

import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.models.PublisherEntity;

public class BookRequest {

    private String isbn;
    private String title;

    public BookRequest() {
    }

    private String description;
    private String language;
    private String edition;
    private AuthorEntity author;
    private PublisherEntity publisher;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public BookRequest(String isbn, String title, String description, String language, String edition, PublisherEntity publisher, AuthorEntity author, CategoryEntity category, String shelfNumber, Integer availableCopies, Integer totalCopies) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.language = language;
        this.edition = edition;
        this.publisher = publisher;
        this.author = author;
        this.category = category;
        this.shelfNumber = shelfNumber;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }

    private CategoryEntity category;
    private String shelfNumber;
    private Integer totalCopies;
    private Integer availableCopies;

}
