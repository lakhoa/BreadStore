package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.exception_handler.CustomException;
import com.example.Miniproject_spring.models.ResponseForm;

import com.example.Miniproject_spring.service.DTO.OrdersDto;
import lombok.extern.slf4j.Slf4j;
import com.example.Miniproject_spring.service.DTO.OrderToppingDto;
import com.example.Miniproject_spring.service.DTO.OrderDto;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.List;


@RestController
@Slf4j
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/order")
    public ResponseEntity<ResponseForm<Orders>> create(@RequestBody List<OrderDto<List<OrderToppingDto>>> orders) throws CustomException {
        ResponseForm<Orders>  rs =  ordersService.createOrder(orders);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }


    @GetMapping("/History")
    public ResponseEntity<OrdersDto> get(@RequestParam Optional<String> date) {
            OrdersDto ordersDto = ordersService.list();
            log.info("Call history");
            return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }
}
