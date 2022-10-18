package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.dto.cart.CartDTO;
import com.justice.ecommerce.dto.cart.CartItemDTO;
import com.justice.ecommerce.dto.cart.addToCartDTO;
import com.justice.ecommerce.entity.Cart;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.entity.User;
import com.justice.ecommerce.exeptions.CustomException;
import com.justice.ecommerce.model.ApiResponse;
import com.justice.ecommerce.model.ResponseDTO;
import com.justice.ecommerce.repository.CartRepository;
import com.justice.ecommerce.service.AuthService;
import com.justice.ecommerce.service.CartService;
import com.justice.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final AuthService authService;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, AuthService authService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.authService = authService;
        this.productService = productService;
    }


    @Override
    public ResponseEntity<?> addToCart(addToCartDTO addToCartDTO, String token) {
        authService.authenticate(token);
        User user = authService.getUserByToken(token);

        Product product = productService.getProductById(addToCartDTO.getProductId());

        Cart cart = new Cart(user,product,addToCartDTO.getQuantity());

        cart = cartRepository.save(cart);

        return ResponseEntity.ok(ApiResponse.ok(cart,"product added to the you cart."));
    }

    @Override
    public ResponseEntity<?> getCartItems(String token) {

        authService.authenticate(token);

        User user = authService.getUserByToken(token);

        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedAtDesc(user);

        List<CartItemDTO> cartItems = new ArrayList<>();

        double totalPrice = 0;
        for (Cart cart: cartList) {
            CartItemDTO cartItemDTO = new CartItemDTO(cart);
            totalPrice+=cartItemDTO.getQuantity()*cart.getProduct().getPrice().toBigInteger().doubleValue();
            cartItems.add(cartItemDTO);
        }

        CartDTO cartDTO = new CartDTO(cartItems,totalPrice);

        return ResponseEntity.ok(ApiResponse.ok(cartDTO,"These are cartItems:"));
    }

    @Override
    public ResponseEntity<?> deleteCaretItem(Long itemId, String token) {

        authService.authenticate(token);

        User user = authService.getUserByToken(token);

        Optional<Cart> optionalCart = cartRepository.findById(itemId);

        if (!optionalCart.isPresent()){
            throw new CustomException("Cart item id is not valid :" + itemId);
        }

        Cart cart = optionalCart.get();
        if(cart.getUser()!=user){
            throw new CustomException("Item does not belong to this user :"+itemId);
        }

        cartRepository.delete(cart);

        return ResponseEntity.ok(ResponseDTO.ok("The item has been deleted"));
    }
}
