package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.BookRequest;
import com.Library.ShelfSync.models.AuthorEntity;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.models.PublisherEntity;
import com.Library.ShelfSync.repository.AuthorRepo;
import com.Library.ShelfSync.repository.BookRepo;
import com.Library.ShelfSync.repository.CategoryRepo;
import com.Library.ShelfSync.repository.PublisherRepo;
import com.Library.ShelfSync.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public Page<BookEntity> handleGetAllBooks(Pageable pageable , String Title , String author , String publisher , String Category) {

        Specification<BookEntity> spec = Specification.allOf();

        if( Title != null && !Title.isBlank() ){
            spec = spec.and(BookSpecification.hasTitle(Title));
        }

        if( author != null && !author.isBlank() ){
            spec = spec.and(BookSpecification.hasAuthor(author));
        }

        if( publisher != null && !publisher.isBlank() ){
            spec = spec.and(BookSpecification.hasPublisher(publisher));
        }

        if( Category != null && !Category.isBlank() ){
            spec = spec.and(BookSpecification.hasCategory(Category));
        }

        return bookRepo.findAll(spec , pageable);
    }

    public Optional<BookEntity> handleGetBookById(Long id) {
        return bookRepo.findById(id);
    }

    public BookEntity createBook(BookRequest request) {

        if (bookRepo.existsByIsbn(request.getIsbn())) {
            throw new RuntimeException("Book already exists");
        }

        AuthorEntity author;

        if (request.getAuthorId() != null) {

            author = authorRepo.findById(request.getAuthorId())
                    .orElseThrow(() ->
                            new RuntimeException("Author not found"));

        } else {

            author = authorRepo.findByName(request.getAuthorName())
                    .orElseGet(() ->
                            authorRepo.save(
                                    new AuthorEntity(request.getAuthorName())
                            ));
        }

        PublisherEntity publisher;

        if (request.getPublisherId() != null) {

            publisher = publisherRepo.findById(request.getPublisherId())
                    .orElseThrow(() ->
                            new RuntimeException("Publisher not found"));

        } else {

            publisher = publisherRepo.findByName(request.getPublisherName())
                    .orElseGet(() ->
                            publisherRepo.save(
                                    new PublisherEntity(request.getPublisherName())
                            ));
        }

        CategoryEntity category;

        if (request.getCategoryId() != null) {

            category = categoryRepo.findById(request.getCategoryId())
                    .orElseThrow(() ->
                            new RuntimeException("Category not found"));

        } else {

            category = categoryRepo.findByName(request.getCategoryName())
                    .orElseGet(() ->
                            categoryRepo.save(
                                    new CategoryEntity(request.getCategoryName())
                            ));
        }

        BookEntity book = new BookEntity(
                request.getIsbn(),
                request.getTitle(),
                request.getLanguage(),
                request.getDescription(),
                request.getEdition(),
                author,
                category,
                publisher,
                request.getShelfNumber(),
                request.getTotalCopies(),
                request.getTotalCopies()
        );

        return bookRepo.save(book);
    }

    //Controller remaining
    public BookEntity updateBook( Long id , BookRequest request){

        BookEntity book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setLanguage(request.getLanguage());
        book.setEdition(request.getEdition());
        book.setShelfNumber(request.getShelfNumber());

        AuthorEntity author = authorRepo.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);

        PublisherEntity publisher = publisherRepo.findById(request.getPublisherId())
                .orElseThrow(() -> new RuntimeException("publisher not found"));

        book.setPublisher(publisher);

        CategoryEntity category = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("category not found"));

        book.setCategory(category);

        int borrowedCopies =
                book.getTotalCopies() - book.getAvailableCopies();

        if (request.getTotalCopies() < borrowedCopies) {
            throw new RuntimeException("Total copies cannot be less than borrowed copies");
        }

        return bookRepo.save(book);

    }

    //Controller remaining
    public void deleteBook(Long id){

        BookEntity book = bookRepo.findById(id)
                .orElseThrow( () -> new RuntimeException("book not found"));

        if( book.getAvailableCopies() != book.getTotalCopies()){
                throw new RuntimeException("Someone has taken the book");
        }

        bookRepo.deleteById(id);

    }

}