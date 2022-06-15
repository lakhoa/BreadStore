package com.example.Miniproject_spring.service.implement;



import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.models.OrderItem;
import com.example.Miniproject_spring.models.RequestOrderForm;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersImplement implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public OrdersImplement(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders createOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public ResponseEntity<ResponseForm<Orders>> order(RequestOrderForm request) {
        List<OrderItem> listOrderItem= request.getOrderItems();
        // ArrayList<Product> listProduct = new ArrayList<Product>();
        // ArrayList<Long> listQuantity = new ArrayList<Long>();
        double totalPrice = 0.0;
        for (OrderItem S : listOrderItem){
            totalPrice += S.getQuantity()*S.getProduct().getPrice();
        }
        LocalDateTime now = LocalDateTime.now();
        Orders orderData = new Orders(null, now ,totalPrice);
        return new ResponseEntity<ResponseForm<Orders>>( new ResponseForm<>( orderData , true, "Order is added!"), HttpStatus.OK);
    }
}
