package com.Library.ShelfSync.services;

import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.repository.UserRepo;
import com.Library.ShelfSync.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Page<UserEntity> findUser(Pageable pageable , Long id , String firstName , String phoneNumber , String accountStatus , String roleName  ){

        Specification<UserEntity> spec = Specification.allOf();

        if( id != null ){
            spec = spec.and(UserSpecification.hasId(id));
        }

        if( firstName != null || !firstName.isBlank() ){
            spec = spec.and(UserSpecification.hasFirstName(firstName));
        }
        if( phoneNumber != null || !phoneNumber.isBlank() ){
            spec = spec.and(UserSpecification.hasPhoneNo(phoneNumber));
        }

        if( accountStatus != null || !accountStatus.isBlank() ){
            spec = spec.and(UserSpecification.hasAccountStatus(accountStatus));
        }

        if( roleName != null || !roleName.isBlank() ){
            spec = spec.and(UserSpecification.hasRole(roleName));
        }

        return userRepo.findAll(pageable , spec);


    }

}
