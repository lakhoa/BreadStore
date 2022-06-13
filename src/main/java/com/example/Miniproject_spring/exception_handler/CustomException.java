package com.example.Miniproject_spring.exception_handler;

public class CustomException extends IllegalAccessException{
    public CustomException(String msg) {
        super(msg);
    }
}
