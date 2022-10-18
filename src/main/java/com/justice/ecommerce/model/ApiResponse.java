package com.justice.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private final boolean success;
    private final String message;
    private final Object data;
    private final LocalDateTime timeStamp;

    public ApiResponse(boolean success, String message, Object data, LocalDateTime timeStamp){
        this.success = success;
        this.message = message;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    public static ApiResponse ok(Object data,String message){
        return new ApiResponse(true,message,data,LocalDateTime.now());
    }
    public static ApiResponse error(String message){
        return new ApiResponse(false,message,null,LocalDateTime.now());
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public String getTimeStamp(){
        return LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
