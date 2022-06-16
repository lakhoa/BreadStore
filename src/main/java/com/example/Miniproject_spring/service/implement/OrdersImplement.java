package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.DTO.OrdersDto;
import com.example.Miniproject_spring.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrdersImplement implements OrdersService {

    private OrdersRepository ordersRepository;
    private OrderDetailsRepository orderDetailsRepository;

    public OrdersImplement(OrdersRepository ordersRepository, OrderDetailsRepository orderDetailsRepository) {
        this.ordersRepository = ordersRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public Orders createOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public OrdersDto list() {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDetail> ordersDetailsList = orderDetailsRepository.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();

        // create empty list

        List ordersDetailList_get = new ArrayList<>();
        double total_all_price = 0;
        int quan = 0;
        for (Orders orders1: ordersList)
        {
            OrdersDto ordersDto = new OrdersDto();
            total_all_price += orders1.getTotal_price();
            ordersDtos.add(ordersDto);
        }

        for (OrdersDetail ordersDetail : ordersDetailsList) {
            // stack in list

            List ordersDetailList_get_in = new ArrayList<>();
            quan += ordersDetail.getQuantity();
                ordersDetailList_get_in.add("name:  " + ordersDetail.getProduct().getName());

                ordersDetailList_get_in.add("quantity:  " + ordersDetail.getQuantity());

                ordersDetailList_get_in.add("price:  " + ordersDetail.getProduct().getPrice());

                ordersDetailList_get_in.add("price total:  " + ordersDetail.getOrders().getTotal_price());

                ordersDetailList_get_in.add("date:  " + ordersDetail.getOrders().getCreatedDate());

                ordersDetailList_get.add(ordersDetailList_get_in);

        }

        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setTotal(total_all_price);
        ordersDto.setQuantity(quan);
        ordersDto.setProduct(ordersDetailList_get);
        return ordersDto;
    }
}
