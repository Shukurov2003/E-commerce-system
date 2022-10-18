package com.justice.ecommerce.service;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WishlistService {
    ResponseEntity<?> createWishList(Product product, String token);


    ResponseEntity<List<ProductDTO>> getWishListForUser(String token);

}
