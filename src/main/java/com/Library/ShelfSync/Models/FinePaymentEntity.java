package com.Library.ShelfSync.Models;

import com.Library.ShelfSync.enums.PaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "fine_payments")
public class FinePaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrow_id")
    private BorrowEntity borrow;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UserEntity student;

    @Column(nullable = false)
    private Integer fineAmount;

    public Long getId() {
        return id;
    }

    public FinePaymentEntity() {
    }

    public FinePaymentEntity(BorrowEntity borrow, UserEntity student, Integer fineAmount, PaymentStatus paymentStatus) {
        this.borrow = borrow;
        this.student = student;
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BorrowEntity getBorrow() {
        return borrow;
    }

    public void setBorrow(BorrowEntity borrow) {
        this.borrow = borrow;
    }

    public UserEntity getStudent() {
        return student;
    }

    public void setStudent(UserEntity student) {
        this.student = student;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @CreationTimestamp
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


}
