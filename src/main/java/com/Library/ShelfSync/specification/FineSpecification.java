package com.Library.ShelfSync.specification;

import com.Library.ShelfSync.models.FineEntity;
import org.springframework.data.jpa.domain.Specification;

public class FineSpecification {

    public static Specification<FineEntity> hasStudentId(Long id){

        return (root, query, cb) ->
                cb.equal(cb.get())

    }

}
