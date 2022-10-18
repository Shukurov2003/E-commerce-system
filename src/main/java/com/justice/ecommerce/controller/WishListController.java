package com.justice.ecommerce.controller;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RequestMapping("/wishlist")
@RestController
public class WishListController {


    private final WishlistService wishlistService;


    public WishListController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addWishList(@RequestBody Product product, @RequestParam String token){

        return wishlistService.createWishList(product,token);
    }

    @GetMapping("/all/{token}")
    public ResponseEntity<List<ProductDTO>> getWishList(@PathVariable String token){
        return wishlistService.getWishListForUser(token);
    }

}
