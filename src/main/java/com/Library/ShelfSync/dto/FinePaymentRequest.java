package com.Library.ShelfSync.dto;

public class FinePaymentRequest {

    private Long borrowId;

    private Long studentId;

    private Integer fineAmount;

    private String paymentStatus;

    public FinePaymentRequest() {
    }

    public FinePaymentRequest(Long borrowId, Long studentId, Integer fineAmount, String paymentStatus) {
        this.borrowId = borrowId;
        this.studentId = studentId;
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
