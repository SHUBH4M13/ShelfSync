package com.Library.ShelfSync.models;

import com.Library.ShelfSync.enums.BorrowStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_records")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "student_id" , nullable = false)
    private UserEntity student;

    @ManyToOne
    @JoinColumn( name = "book_id", nullable = false)
    private BookEntity book;

    @ManyToOne
    @JoinColumn( name = "issued_by", nullable = false)
    private UserEntity issuedBy;

    @Column(nullable = false)
    private LocalDateTime issueDate;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    @Column(nullable = true)
    private LocalDateTime returnDate;

    public BorrowEntity() {
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public BorrowEntity(UserEntity student, BookEntity book, LocalDateTime issueDate, UserEntity issuedBy, LocalDateTime dueDate, LocalDateTime returnDate, BorrowStatus borrowStatus, Integer fineAmount) {
        this.student = student;
        this.book = book;
        this.issueDate = issueDate;
        this.issuedBy = issuedBy;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.borrowStatus = borrowStatus;
        this.fineAmount = fineAmount;
    }

    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getStudent() {
        return student;
    }

    public void setStudent(UserEntity student) {
        this.student = student;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(UserEntity issuedBy) {
        this.issuedBy = issuedBy;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Enumerated(EnumType.STRING)
    private BorrowStatus borrowStatus;

    private Integer fineAmount;

}
