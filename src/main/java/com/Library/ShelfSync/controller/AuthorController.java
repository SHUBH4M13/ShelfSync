package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.AuthorRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PostMapping("/api/author/create")
    AuthorEntity HandleCreateAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.HandleCreateAuthor(authorRequest);
    }

}
