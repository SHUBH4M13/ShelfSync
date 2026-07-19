package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.BorrowRequest;
import com.Library.ShelfSync.enums.BorrowStatus;
import com.Library.ShelfSync.enums.RoleName;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.models.BorrowEntity;
import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.repository.BookRepo;
import com.Library.ShelfSync.repository.BorrowRepo;
import com.Library.ShelfSync.repository.UserRepo;
import com.Library.ShelfSync.specification.BorrowSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    public Page<BorrowEntity> FindBorrow(Pageable pageable , Long id , String studentName , String bookName , LocalDateTime issueDate){

        Specification<BorrowEntity> spec = Specification.allOf();

        if( id != null ){
            spec = spec.and(BorrowSpecification.hasId(id));
        }

        if( studentName != null && !studentName.isBlank() ){
            spec = spec.and(BorrowSpecification.hasStudentName(studentName));
        }

        if( bookName != null && !bookName.isBlank() ){
            spec = spec.and(BorrowSpecification.hasBookName(bookName));
        }

        if( issueDate != null ){
            spec = spec.and(BorrowSpecification.hasIssueDate(issueDate));
        }

        return borrowRepo.findAll(spec , pageable);

    }


    @Transactional
    public BorrowEntity CreateBorrow(BorrowRequest borrowRequest){

        UserEntity studentUser = userRepo.findByEmail(borrowRequest.getStudent_email())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        UserEntity librarianUser = userRepo.findByEmail(borrowRequest.getLibrarian_email())
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

        BookEntity book = bookRepo.findByTitle(borrowRequest.getBook_title())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Book is not available");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        if (studentUser.getRole().getRoleName() != RoleName.STUDENT) {
            throw new RuntimeException("User is not a student");
        }

        if (librarianUser.getRole().getRoleName() != RoleName.LIBRARIAN) {
            throw new RuntimeException("User is not a librarian");
        }


        LocalDateTime issueDate = LocalDateTime.now();

        LocalDateTime DueDate = issueDate.plusDays(10);

        BorrowEntity borrow = new BorrowEntity(studentUser , book , issueDate , librarianUser , DueDate , null , BorrowStatus.BORROWED , 0);

        borrowRepo.save(borrow);

        return borrow;
    }

}
