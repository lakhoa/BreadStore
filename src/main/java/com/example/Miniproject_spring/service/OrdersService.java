package com.example.Miniproject_spring.service;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.service.DTO.OrdersDto;

import java.util.List;

public interface OrdersService {
    Orders createOrder(Orders orders);

    OrdersDto list();

}
