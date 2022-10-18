package com.justice.ecommerce.controller;

import com.justice.ecommerce.dto.cart.addToCartDTO;
import com.justice.ecommerce.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody addToCartDTO addToCartDTO, @RequestParam("token") String token){
        return cartService.addToCart(addToCartDTO,token);
    }

    @GetMapping("/cart_items")
    public ResponseEntity<?> getCartItems(@RequestParam("token") String token){
        return cartService.getCartItems(token);
    }
    @DeleteMapping("/delete/{item_id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable("item_id") Long itemId,@RequestParam("token") String token){
        return cartService.deleteCaretItem(itemId,token);
    }
}

