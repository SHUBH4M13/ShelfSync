package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.BookRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.repository.AuthorRepo;
import com.Library.ShelfSync.repository.BookRepo;
import com.Library.ShelfSync.repository.CategoryRepo;
import com.Library.ShelfSync.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    void HandleCreateBook(BookRequest bookRequest){

    }

}
