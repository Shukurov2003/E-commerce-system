package com.justice.ecommerce.service;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> createProduct(ProductDTO productDTO);
    ResponseEntity<?> getAll();
    ResponseEntity<?> updateProduct(ProductDTO productDTO);
    Product getProductById(Long id);
}
