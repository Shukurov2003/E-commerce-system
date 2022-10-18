package com.justice.ecommerce.exeptions;

public class ProductNotPresentException extends IllegalArgumentException {
    public ProductNotPresentException(String msg) {
        super(msg);
    }
}
