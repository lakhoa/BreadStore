package com.example.Miniproject_spring.service;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;


public interface OrdersDetailService {

    void createOrder(OrdersDetailDto ordersDetailDto);
}
