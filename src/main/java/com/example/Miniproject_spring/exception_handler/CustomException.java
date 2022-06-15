package com.example.Miniproject_spring.exception_handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomException extends IllegalAccessException{
    public CustomException(String msg) {
        super(msg);
        log.error("error");
    }
}
