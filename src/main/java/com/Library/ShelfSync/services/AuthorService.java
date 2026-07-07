package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.AuthorRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public AuthorEntity HandleCreateAuthor(AuthorRequest authorRequest){

        if(authorRepo.existsByName(authorRequest.getName())){
            throw new RuntimeException("Author already exists");
        }

        AuthorEntity author = new AuthorEntity(
                authorRequest.getName()
        );
        return authorRepo.save(author);
    }



}
