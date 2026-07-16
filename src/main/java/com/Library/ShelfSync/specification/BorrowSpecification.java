package com.Library.ShelfSync.specification;

import com.Library.ShelfSync.models.BorrowEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class BorrowSpecification {

    public static Specification<BorrowEntity> hasId(Long Id){

        if (Id == null) {
            return null;
        }

        return((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"),Id));
    }



        public static Specification<BorrowEntity> hasStudentName(String studentName){

        if (studentName == null || studentName.isBlank()) {
            return null;
        }

            return((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("student").get("firstName")
                            ), "%" + studentName.toLowerCase() + "%"
                    ));
    }

    public static Specification<BorrowEntity> hasBookName(String bookName){

        if (bookName == null || bookName.isBlank()) {
            return null;
        }

        return((root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("book").get("title")
                        ), "%" + bookName.toLowerCase() + "%"
                ));
    }

    public static Specification<BorrowEntity> hasIssueDate(LocalDateTime issueDate){

        return((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("issueDate") , issueDate));
    }



}
