package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.DTO.OrderToppingDto;
import com.example.Miniproject_spring.service.OrdersDetailService;
import com.example.Miniproject_spring.service.OrdersService;
import com.example.Miniproject_spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrdersDetailImplement implements OrdersDetailService {
    private OrderDetailsRepository orderDetailsRepository;
    private OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;


    public OrdersDetailImplement(OrderDetailsRepository orderDetailsRepository, OrdersRepository ordersRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrder(OrderToppingDto orders_detail) {
    }
}
