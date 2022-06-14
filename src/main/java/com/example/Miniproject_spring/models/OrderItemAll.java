package com.example.Miniproject_spring.models;

import java.util.List;

public class OrderItemAll {
    List<OrderItem> orderItems;

    public OrderItemAll(List<OrderItem> items) {
        this.orderItems = items;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
