package com.Library.ShelfSync.services;

import com.Library.ShelfSync.models.BorrowEntity;
import com.Library.ShelfSync.repository.BorrowRepo;
import com.Library.ShelfSync.specification.BookSpecification;
import com.Library.ShelfSync.specification.BorrowSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    public Page<BorrowEntity> FindBorrow(Pageable pageable , String studentName , String bookName , LocalDateTime issueDate){

        Specification<BorrowEntity> spec = Specification.allOf();

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


}
