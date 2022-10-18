package com.justice.ecommerce.controller;

import com.justice.ecommerce.entity.Category;
import com.justice.ecommerce.model.ApiResponse;
import com.justice.ecommerce.service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000/ ")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
       return categoryService.createCategory(category);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return categoryService.getAll();
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Long categoryId,@RequestBody Category category){
        return categoryService.updateCategory(categoryId,category);
    }

}

