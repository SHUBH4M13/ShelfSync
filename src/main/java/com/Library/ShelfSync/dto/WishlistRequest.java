package com.Library.ShelfSync.dto;

public class WishlistRequest {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public WishlistRequest() {
    }

    public Long getBookId() {
        return bookId;
    }

    public WishlistRequest(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    private Long bookId;

}
