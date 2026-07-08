package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.CategoryRequest;
import com.Library.ShelfSync.models.CategoryEntity;
import com.Library.ShelfSync.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PostMapping("/api/Category/create")
    CategoryEntity handleCreateCategory(@RequestBody CategoryRequest CategoryRequest){
        return categoryService.handleCreateCategory(CategoryRequest);
    }

    @GetMapping("/api/Category/all")
    List<CategoryEntity> handleGetAllCategory(){
        return categoryService.handleGetAllCategory();
    }

    @GetMapping("/api/Category/{id}")
    CategoryEntity handleGetCategory(@PathVariable Long id){
        return categoryService.handleGetCategory(id);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @PatchMapping("/api/Category/edit/{id}")
    CategoryEntity handleEditCategory(@PathVariable Long id , @RequestBody CategoryRequest CategoryRequest){
        return categoryService.handleEditCategory(id,CategoryRequest);
    }

    @PreAuthorize("hasAnyRole('LIBRARIAN' , 'ADMIN')")
    @DeleteMapping("/api/Category/delete/{id}")
    Long handleDeleteCategory(@PathVariable Long id){
        return categoryService.handleDeleteCategory(id);
    }

}
