package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersImplement implements OrdersService {

    private OrdersRepository ordersRepository;

    public OrdersImplement(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders createOrder(Orders orders) {
        return ordersRepository.save(orders);
    }
}
