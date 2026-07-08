package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.PublisherRequest;
import com.Library.ShelfSync.models.PublisherEntity;
import com.Library.ShelfSync.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {


    @Autowired
    private PublisherService publisherService;

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PostMapping("/api/publisher/create")
    PublisherEntity handleCreatePublisher(@RequestBody PublisherRequest PublisherRequest){
        return publisherService.handleCreatePublisher(PublisherRequest);
    }

    @GetMapping("/api/publisher/all")
    List<PublisherEntity> handleGetAllPublisher(){
        return publisherService.handleGetAllPublisher();
    }

    @GetMapping("/api/publisher/{id}")
    PublisherEntity handleGetPublisher(@PathVariable Long id){
        return publisherService.handleGetPublisher(id);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PatchMapping("/api/publisher/edit/{id}")
    PublisherEntity handleEditPublisher(@PathVariable Long id , @RequestBody PublisherRequest PublisherRequest){
        return publisherService.handleEditPublisher(id,PublisherRequest);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @DeleteMapping("/api/publisher/delete/{id}")
    Long handleDeletePublisher(@PathVariable Long id){
        return publisherService.handleDeletePublisher(id);
    }


}
