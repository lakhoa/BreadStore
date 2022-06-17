package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.repository.OrdersRepository;

import com.example.Miniproject_spring.service.DTO.OrdersDto;
import lombok.extern.slf4j.Slf4j;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;
import com.example.Miniproject_spring.service.DTO.RequestDto;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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
    public ResponseEntity<ResponseForm<Orders>> create(@RequestBody List<RequestDto<List<OrdersDetailDto>>> orders) {
        ResponseForm<Orders>  rs =  ordersService.createOrder(orders);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }


    @GetMapping("/History")
    public ResponseEntity<OrdersDto> get() {
            OrdersDto ordersDto = ordersService.list();
            log.info("Call history");
            return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }
}
