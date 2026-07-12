package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.BookRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.repository.AuthorRepo;
import com.Library.ShelfSync.repository.BookRepo;
import com.Library.ShelfSync.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<BookEntity> handleGetAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<BookEntity> handleGetBook(Long id){
        return bookRepo.findById(id);
    }

    public BookEntity handleCreateBook(BookRequest bookRequest){

        if( bookRequest.getAuthor() == null ){
            AuthorEntity author = new AuthorEntity(boo)
        }

    }

}
