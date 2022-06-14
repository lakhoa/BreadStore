package com.example.Miniproject_spring.controller;


import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.models.RequestOrderForm;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/testOrders")
    public Orders create(@RequestBody Orders product)
    {
        return ordersService.createOrder(product);
    }
    @PostMapping("/orders")
    public ResponseEntity<ResponseForm<Orders>> orderProduct(@RequestBody RequestOrderForm requestOrderForm){
        return ordersService.order(requestOrderForm);
    }
}
