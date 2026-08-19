package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.WishlistRequest;
import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.models.WishlistEntity;
import com.Library.ShelfSync.repository.BookRepo;
import com.Library.ShelfSync.repository.UserRepo;
import com.Library.ShelfSync.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    public WishlistRepo wishlistRepo;

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public BookRepo bookRepo;

    public WishlistEntity addWishlist(WishlistRequest wishlistRequest){

        UserEntity user = userRepo.findById(wishlistRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        BookEntity book = bookRepo.findById(wishlistRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book not found"));

        WishlistEntity wishlist = new WishlistEntity();

        wishlist.setBook(book);
        wishlist.setStudent(user);

        return wishlistRepo.save(wishlist);

    }

    public List<WishlistEntity> getWishlist(Long userid){

        UserEntity user = userRepo.findById(userid)
                .orElseThrow(() -> new RuntimeException("user not found"));

        List<WishlistEntity> wishlist = wishlistRepo.findByStudent(user);

        return wishlist;

    }

}
