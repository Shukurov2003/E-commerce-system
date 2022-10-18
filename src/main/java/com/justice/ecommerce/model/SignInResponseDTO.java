package com.justice.ecommerce.model;

import javax.ws.rs.core.Response;

public class SignInResponseDTO {

    private String status;
    private String token;

    public SignInResponseDTO(String status, String token) {
        this.status = status;
        this.token = token;
    }
    public SignInResponseDTO(String status){
        this.status = status;
    }

    public static SignInResponseDTO ok(String token){
        return new SignInResponseDTO(Response.Status.OK.toString(),token);
    }
    public static SignInResponseDTO failed(){
        return new SignInResponseDTO(Response.Status.BAD_REQUEST.toString());
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SignInResponseDTO{" +
                "status='" + status + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
