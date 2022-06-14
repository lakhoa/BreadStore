package com.example.Miniproject_spring.service.implement;

import com.example.Miniproject_spring.entity.Orders_detail;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.service.OrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDetailImplement implements OrdersDetailService {
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired

    public OrdersDetailImplement(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public Orders_detail createOrder(Orders_detail orders_detail) {
        return orderDetailsRepository.save(orders_detail);

    }
}
