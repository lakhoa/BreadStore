package com.example.Miniproject_spring.service;
import com.example.Miniproject_spring.entity.Orders;

import com.example.Miniproject_spring.exception_handler.CustomException;
import com.example.Miniproject_spring.service.DTO.OrdersDto;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.service.DTO.OrderToppingDto;
import com.example.Miniproject_spring.service.DTO.OrderDto;


import java.util.List;

public interface OrdersService {
    ResponseForm<Orders> createOrder(List<OrderDto<List<OrderToppingDto>>> ordersRequest) throws CustomException;

    OrdersDto list();

}
