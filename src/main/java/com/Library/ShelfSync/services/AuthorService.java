package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.AuthorRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.repository.AuthorRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public AuthorEntity handleCreateAuthor(@NotNull AuthorRequest authorRequest){

        if(authorRepo.existsByName(authorRequest.getName())){
            throw new RuntimeException("Author already exists");
        }

        AuthorEntity author = new AuthorEntity(
                authorRequest.getName()
        );
        return authorRepo.save(author);
    }

    public List<AuthorEntity> handleGetAllAuthor(){
        return authorRepo.findAll();
    }

    public AuthorEntity handleGetAuthor(Long id){
        return authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public AuthorEntity handleEditAuthor(Long id , AuthorRequest authorRequest){

        AuthorEntity author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setName(authorRequest.getName());

        return authorRepo.save(author);

    }


    public Long handleDeleteAuthor(Long id){
        AuthorEntity author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorRepo.delete(author);

        return id;
    }


}
