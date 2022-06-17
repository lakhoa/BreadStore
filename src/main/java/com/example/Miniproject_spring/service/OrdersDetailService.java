package com.example.Miniproject_spring.service;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;

import java.util.List;


public interface OrdersDetailService {

    void createOrder(OrdersDetailDto ordersDetailDto);

    OrdersDetail findByorders(Long id);
}
