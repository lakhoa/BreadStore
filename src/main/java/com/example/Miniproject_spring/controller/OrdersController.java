package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public class OrdersController {
   /*
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/testorders")
    public Orders create(@RequestBody Orders orders)
    {
        return ordersService.createOrder(orders);
    }

    */
}
