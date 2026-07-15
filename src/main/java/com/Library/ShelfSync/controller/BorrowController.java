package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.models.BorrowEntity;
import com.Library.ShelfSync.services.BookService;
import com.Library.ShelfSync.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/borrow/")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping
    private Page<BorrowEntity> handleGetBorrow(
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) LocalDateTime issueDate,
            @RequestParam (defaultValue = "1" , required = false) int PageNo ,
            @RequestParam (defaultValue = "5" , required = false) int PageSize ,
            @RequestParam (defaultValue = "id") String sortBy ,
            @RequestParam (defaultValue = "ASC") String sortDirection
    ){

        Sort sort = null;

        if( sortDirection == "DESC"){
            sort = Sort.by("id").descending();
        } else {
            sort = Sort.by("id").ascending();
        }

        Pageable pageable = PageRequest.of(PageNo - 1 , PageSize , sort );

        return borrowService.FindBorrow(pageable , studentName , bookName , issueDate);

    }

}
