package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.PublisherRequest;
import com.Library.ShelfSync.models.PublisherEntity;
import com.Library.ShelfSync.repository.PublisherRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    
    @Autowired
    private PublisherRepo publisherRepo;


    public PublisherEntity handleCreatePublisher(@NotNull PublisherRequest publisherRequest){

        if(publisherRepo.existsByName(publisherRequest.getName())){
            throw new RuntimeException("Publisher already exists");
        }

        PublisherEntity Publisher = new PublisherEntity(
                publisherRequest.getName()
        );
        return publisherRepo.save(Publisher);
    }

    public List<PublisherEntity> handleGetAllPublisher(){
        return publisherRepo.findAll();
    }

    public PublisherEntity handleGetPublisher(Long id){
        return publisherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    public PublisherEntity handleEditPublisher(Long id , PublisherRequest PublisherRequest){

        PublisherEntity Publisher = publisherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        Publisher.setName(PublisherRequest.getName());

        return publisherRepo.save(Publisher);

    }


    public Long handleDeletePublisher(Long id){
        PublisherEntity Publisher = publisherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        publisherRepo.delete(Publisher);

        return id;
    }
    
}
