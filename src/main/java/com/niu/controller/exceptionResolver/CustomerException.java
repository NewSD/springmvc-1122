package com.niu.controller.exceptionResolver;

/**
 * Created by ami on 2018/11/23.
 */
public class CustomerException extends Exception{

    private String message;

    public CustomerException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
