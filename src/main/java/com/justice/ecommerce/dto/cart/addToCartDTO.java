package com.justice.ecommerce.dto.cart;

import javax.validation.constraints.NotNull;

public class addToCartDTO {

    private Long id;

    private @NotNull Long productId;

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private @NotNull int quantity;

    public addToCartDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
