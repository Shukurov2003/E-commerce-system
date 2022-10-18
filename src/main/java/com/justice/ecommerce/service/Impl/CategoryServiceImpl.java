package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.entity.Category;
import com.justice.ecommerce.model.ApiResponse;
import com.justice.ecommerce.repository.CategoryRepository;
import com.justice.ecommerce.repository.ProductRepository;
import com.justice.ecommerce.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> createCategory(Category category) {
        categoryRepository.save(category);
        return ResponseEntity.ok(ApiResponse.ok(category,"Category has been created!"));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(categoryRepository.findAll(),"Here All categories are:"));
    }

    @Override
    public ResponseEntity<?> updateCategory(Long categoryId, Category category) {
        category.setId(categoryId);
        categoryRepository.save(category);
      return ResponseEntity.ok(ApiResponse.ok(category,"Category has been updated!"));

    }




}
