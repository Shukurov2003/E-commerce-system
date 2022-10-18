package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.entity.User;
import com.justice.ecommerce.entity.WishList;
import com.justice.ecommerce.mapper.ProductDTOFromProductService;
import com.justice.ecommerce.model.ApiResponse;
import com.justice.ecommerce.model.ResponseDTO;
import com.justice.ecommerce.repository.WishListRepository;
import com.justice.ecommerce.service.AuthService;
import com.justice.ecommerce.service.ProductService;
import com.justice.ecommerce.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WishListServiceImpl implements WishlistService {

    private final WishListRepository wishListRepository;
    private final AuthService authService;
    private final ProductService productService;
    private final ProductDTOFromProductService fromProductService;

    public WishListServiceImpl(WishListRepository wishListRepository, AuthService authService, ProductService productService, ProductDTOFromProductService fromProductService) {
        this.wishListRepository = wishListRepository;
        this.authService = authService;
        this.productService = productService;
        this.fromProductService = fromProductService;
    }

    @Override
    public ResponseEntity<?> createWishList(Product product, String token) {

        authService.authenticate(token);

        User user = authService.getUserByToken(token);

        WishList wishList = new WishList(user,product);

        wishListRepository.save(wishList);

        return ResponseEntity.ok(ApiResponse.ok(wishList,"wishListAdded"));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getWishListForUser(String token) {
        User user = authService.getUserByToken(token);
        final List<WishList> wishLists = wishListRepository.findAllByUser(user);

        if(Objects.isNull(wishLists)){
            throw null;
        }

        List<ProductDTO> productDTOS = new ArrayList<>();
        for (WishList w: wishLists) {
            productDTOS.add(fromProductService.getProductDTOFromProduct(w.getProduct()));
        }
        return ResponseEntity.ok(productDTOS);
    }
}
