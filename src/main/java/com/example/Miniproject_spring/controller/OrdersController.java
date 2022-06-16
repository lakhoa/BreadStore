package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.DTO.OrdersDto;
import com.example.Miniproject_spring.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


@RestController
@Slf4j
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/testorders")
    public Orders create(@RequestBody Orders orders)
    {
        return ordersService.createOrder(orders);
    }


    @GetMapping("/History")
    public ResponseEntity<OrdersDto> get(@RequestParam Optional<String> date) {
            OrdersDto ordersDto = ordersService.list();
            log.info("Call history");
            return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }
}
