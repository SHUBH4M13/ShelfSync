package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.BookRequest;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    private Page<BookEntity> handleGetAllBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String category,
            @RequestParam (defaultValue = "1" , required = false) int PageNo ,
            @RequestParam (defaultValue = "5" , required = false) int PageSize ,
            @RequestParam (defaultValue = "title") String sortBy ,
            @RequestParam (defaultValue = "ASC") String sortDirection
    ){

        Sort sort = null;

        if( sortDirection.equalsIgnoreCase("ASC") ){
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(PageNo - 1 , PageSize , sort );

        return bookService.handleGetAllBooks(pageable , title , author , publisher , category);
    }

    @GetMapping("{id}")
    private Optional<BookEntity> handleGetBookById(@PathVariable Long id){
        return bookService.handleGetBookById(id);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PostMapping("create")
    private BookEntity handleCreateBook(@RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }



}
