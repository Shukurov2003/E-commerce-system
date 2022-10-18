package com.justice.ecommerce.dto.cart;

import java.math.BigDecimal;
import java.util.List;

public class CartDTO {

   private List<CartItemDTO> cartItems;
   private BigDecimal totalCost;

    public CartDTO(List<CartItemDTO> cartItems, double totalPrice) {
        this.cartItems =cartItems;
        this.totalCost = BigDecimal.valueOf(totalPrice);
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public CartDTO() {
    }
}
