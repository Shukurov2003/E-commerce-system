package com.justice.ecommerce.dto.user;

import javax.validation.constraints.NotBlank;

public class SignInDTO {

    private @NotBlank String email;
    private @NotBlank String password;

    public SignInDTO(String email,String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
