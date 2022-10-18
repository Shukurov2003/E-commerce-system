package com.justice.ecommerce.service;

import com.justice.ecommerce.dto.cart.addToCartDTO;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<?> addToCart(addToCartDTO addToCartDTO, String token);

    ResponseEntity<?> getCartItems(String token);


    ResponseEntity<?> deleteCaretItem(Long itemId, String token);
}
