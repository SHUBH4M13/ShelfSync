package com.Library.ShelfSync.services;

import com.Library.ShelfSync.dto.CategoryRequest;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.repository.CategoryRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryEntity handleCreateCategory(@NotNull CategoryRequest CategoryRequest){

        if(categoryRepo.existsByName(CategoryRequest.getName())){
            throw new RuntimeException("Category already exists");
        }

        CategoryEntity Category = new CategoryEntity(
                CategoryRequest.getName()
        );
        return categoryRepo.save(Category);
    }

    public List<CategoryEntity> handleGetAllCategory(){
        return categoryRepo.findAll();
    }

    public CategoryEntity handleGetCategory(Long id){
        return categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public CategoryEntity handleEditCategory(Long id , CategoryRequest CategoryRequest){

        CategoryEntity Category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Category.setName(CategoryRequest.getName());

        return categoryRepo.save(Category);

    }


    public Long handleDeleteCategory(Long id){
        CategoryEntity Category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepo.delete(Category);

        return id;
    }
}
