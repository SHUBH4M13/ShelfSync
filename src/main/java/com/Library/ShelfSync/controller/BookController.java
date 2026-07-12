package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.BookRequest;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/book/all")
    private List<BookEntity> handleGetAllBooks(){
        return bookService.handleGetAllBooks();
    }

    @GetMapping("/api/book/{id}")
    private Optional<BookEntity> handleGetBook(@PathVariable Long id){
        return bookService.handleGetBook(id);
    }

    @PostMapping("/api/book/create")
    private BookEntity handleCreateBook(@RequestBody BookRequest bookRequest){

    }

}
