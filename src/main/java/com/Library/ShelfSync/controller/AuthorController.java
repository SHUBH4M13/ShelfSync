package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.AuthorRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PostMapping("/api/author/create")
    AuthorEntity handleCreateAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.handleCreateAuthor(authorRequest);
    }

    @GetMapping("/api/author/all")
    List<AuthorEntity> handleGetAllAuthor(){
        return authorService.handleGetAllAuthor();
    }

    @GetMapping("/api/author/{id}")
    AuthorEntity handleGetAuthor(@PathVariable Long id){
        return authorService.handleGetAuthor(id);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PatchMapping("/api/author/edit/{id}")
    AuthorEntity handleEditAuthor(@PathVariable Long id){

    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @DeleteMapping("/api/author/delete/{id}")
    Long handleDeleteAuthor(@PathVariable Long id){
        return authorService.handleDeleteAuthor(id);
    }


}
