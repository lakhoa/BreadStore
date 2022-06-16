package com.example.Miniproject_spring.service;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.Product;

import com.example.Miniproject_spring.service.DTO.OrdersDto;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;
import com.example.Miniproject_spring.service.DTO.RequestDto;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface OrdersService {
    ResponseForm<Orders> createOrder(List<RequestDto<List<OrdersDetailDto>>> ordersRequest);
    void checkValidQuantity(List<RequestDto<List<OrdersDetailDto>>> ordersRequest);

    OrdersDto list();

}
