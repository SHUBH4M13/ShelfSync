package com.Library.ShelfSync.dto;

import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.models.PublisherEntity;

public class BookRequest {

    private String isbn;
    private String title;
    private String description;
    private String language;
    private String edition;

    private Long authorId;
    private String authorName;

    private Long publisherId;
    private String publisherName;

    private Long categoryId;
    private String categoryName;


    private String shelfNumber;
    private Integer totalCopies;
    private Integer availableCopies;

    public BookRequest() {
    }

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public BookRequest(String isbn, String title, String description, String language, String edition, Long authorId, String authorName, Long publisherId, String publisherName, Long categoryId, String categoryName, String shelfNumber, Integer totalCopies, Integer availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.language = language;
        this.edition = edition;
        this.authorId = authorId;
        this.authorName = authorName;
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.shelfNumber = shelfNumber;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }


}
