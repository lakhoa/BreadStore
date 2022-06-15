package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;
import com.example.Miniproject_spring.service.OrdersDetailService;
import com.example.Miniproject_spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class OrdersDetailImplement implements OrdersDetailService {
    private OrderDetailsRepository orderDetailsRepository;
    private OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    public OrdersDetailImplement(OrderDetailsRepository orderDetailsRepository, OrdersRepository ordersRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrder(OrdersDetailDto orders_detail) {
        Product product = productService.findById(orders_detail.getProductId());
        OrdersDetail orders_detail1= new OrdersDetail();

        orders_detail1.setProduct(product);
        orders_detail1.setQuantity(orders_detail.getQuantity());

        double price = (orders_detail1.getQuantity() * product.getPrice());
        Orders orders = new Orders();
        orders.setTotal_price(price);

        LocalDateTime now = LocalDateTime.now();
        orders.setCreatedDate(now);

        ordersRepository.save(orders);
        log.info("save order");
        orderDetailsRepository.save(orders_detail1);
        log.info("save orderDetail");
    }
}
