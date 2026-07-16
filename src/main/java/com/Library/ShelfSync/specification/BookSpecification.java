package com.Library.ShelfSync.specification;

import com.Library.ShelfSync.models.BookEntity;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<BookEntity> hasTitle(String Title) {

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("title")),
                        "%" + Title.toLowerCase() + "%"
                );

    }

    public static Specification<BookEntity> hasAuthor(String author) {

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("author").get("name")),
                        "%" + author.toLowerCase() + "%"
                );

    }

    public static Specification<BookEntity> hasPublisher(String publisher) {

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("publisher").get("name")),
                        "%" + publisher.toLowerCase() + "%"
                );

    }

    public static Specification<BookEntity> hasCategory(String category) {

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("category").get("name")),
                        "%" + category.toLowerCase() + "%"
                );

    }

}