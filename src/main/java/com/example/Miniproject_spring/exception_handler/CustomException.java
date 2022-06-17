package com.example.Miniproject_spring.exception_handler;

import com.example.Miniproject_spring.service.DTO.OrderToppingDto;
import com.example.Miniproject_spring.service.DTO.OrderDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CustomException extends IllegalAccessException{

    List<OrderDto<List<OrderToppingDto>>> requestBody;


    public CustomException(String msg, List<OrderDto<List<OrderToppingDto>>> error) {
        super(msg);
        this.requestBody  = error;
        log.error("error");
    }

    public List<OrderDto<List<OrderToppingDto>>> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(List<OrderDto<List<OrderToppingDto>>> requestBody) {
        this.requestBody = requestBody;
    }
}
