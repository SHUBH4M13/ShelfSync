package com.Library.ShelfSync.specification;

import com.Library.ShelfSync.models.BookEntity;
import com.Library.ShelfSync.models.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<UserEntity> hasId(Long id) {

        return (root, query, cb) ->
                cb.equal(root.get("id") , id);

    }

    public static Specification<UserEntity> hasFirstName(String Title) {

        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("first_name")),
                        "%" + Title.toLowerCase() + "%"
                );

    }

    public static Specification<UserEntity> hasPhoneNo( String PhoneNo ) {

        return (root, query, cb) ->
                cb.equal(root.get("phoneNumber") , PhoneNo);

    }

    public static Specification<UserEntity> hasAccountStatus( String accountStatus ) {

        return (root, query, cb) ->
                cb.equal(root.get("accountStatus") , accountStatus);

    }

    public static Specification<UserEntity> hasRole( String roleName ) {

        return (root, query, cb) ->
                cb.equal(root.get("role").get("roleName") , roleName);

    }

}
