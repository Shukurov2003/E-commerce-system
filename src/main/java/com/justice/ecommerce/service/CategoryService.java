package com.justice.ecommerce.service;

import com.justice.ecommerce.entity.Category;
import org.springframework.http.ResponseEntity;


public interface CategoryService {

    ResponseEntity<?> createCategory(Category category);
    ResponseEntity<?> getAll();
    ResponseEntity<?> updateCategory(Long categoryId,Category category);



}
