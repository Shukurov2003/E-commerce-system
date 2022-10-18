package com.justice.ecommerce.dto.cart;

import com.justice.ecommerce.entity.Cart;
import com.justice.ecommerce.entity.Product;

public class CartItemDTO {
    private Long id;
    private Product product;
    private int quantity;

    public CartItemDTO() {
    }

    public CartItemDTO(Cart cart) {
        this.id = cart.getId();
        this.product = cart.getProduct();
        this.quantity = cart.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
