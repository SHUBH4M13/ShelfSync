package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.BorrowRequest;
import com.Library.ShelfSync.models.BorrowEntity;
import com.Library.ShelfSync.services.BookService;
import com.Library.ShelfSync.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(required = false) Long id,
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

        return borrowService.FindBorrow(pageable , id ,studentName , bookName , issueDate);

    }

    @PostMapping("create")
    private ResponseEntity<BorrowEntity> handleCreateBorrow(@RequestBody BorrowRequest borrowRequest){
        BorrowEntity borrow = borrowService.CreateBorrow(borrowRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(borrow);
    }

}
