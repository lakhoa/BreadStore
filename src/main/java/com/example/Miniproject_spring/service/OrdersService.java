package com.example.Miniproject_spring.service;



import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.models.RequestOrderForm;
import com.example.Miniproject_spring.models.ResponseForm;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface OrdersService {
    Orders createOrder(Orders orders);


    // order
    public ResponseEntity<ResponseForm<Orders>> order(RequestOrderForm request);

}
