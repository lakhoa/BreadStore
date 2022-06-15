package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders_detail;
import com.example.Miniproject_spring.service.OrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrdersDetailController {
    OrdersDetailService ordersDetailService;

    @Autowired

    public OrdersDetailController(OrdersDetailService ordersDetailService) {
        this.ordersDetailService = ordersDetailService;
    }

    @PostMapping("/test")
    public void createOrders(@RequestBody OrdersDetailDto ordersDetailDto)
    {
        
        ordersDetailService.createOrder(ordersDetailDto);
    }
}