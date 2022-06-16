package com.example.Miniproject_spring.service.DTO;

import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.entity.Product;

import java.util.List;

public class OrdersDto {

    private Double total;

    private Integer quantity;

    private List product;


    public OrdersDto()
    {

    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List getProduct() {
        return product;
    }

    public void setProduct(List product) {
        this.product = product;
    }

    public OrdersDto(OrdersDetail ordersDetail) {
        this.total = ordersDetail.getProduct().getPrice();
    }
}
