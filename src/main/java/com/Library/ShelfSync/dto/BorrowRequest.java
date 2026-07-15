package com.Library.ShelfSync.dto;

import java.time.LocalDateTime;

public class BorrowRequest {

    private String student_email;
    private String book_title;
    private String librarian_email;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public BorrowRequest() {
    }

    public BorrowRequest(String student_email, String book_title, String librarian_email, LocalDateTime issueDate, LocalDateTime dueDate) {
        this.student_email = student_email;
        this.book_title = book_title;
        this.librarian_email = librarian_email;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getLibrarian_email() {
        return librarian_email;
    }

    public void setLibrarian_email(String librarian_email) {
        this.librarian_email = librarian_email;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

}
