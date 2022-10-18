package com.justice.ecommerce.exeptions;

public class AuthenticationFailedException extends IllegalArgumentException {

    public AuthenticationFailedException(String msg){
        super(msg);
    }
}
