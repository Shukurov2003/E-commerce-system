package com.justice.ecommerce.model;

import javax.ws.rs.core.Response;

public class ResponseDTO {
    private final String status;
    private final String message;


    public ResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public static ResponseDTO ok(String message){
        return new ResponseDTO(Response.Status.OK.toString(),message);
    }

    public static ResponseDTO error(String message){
        return new ResponseDTO(Response.Status.BAD_REQUEST.toString(),message);
    }


    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
