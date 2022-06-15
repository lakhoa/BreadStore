package com.example.Miniproject_spring.service.DTO;

import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.Product;

import javax.validation.constraints.NotNull;

public class OrdersDetailDto {
    private Long id;
    @NotNull
    private Integer quantity;
    private Long productId;
    private Long ordersId;

    public OrdersDetailDto()
    {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public OrdersDetailDto(Long id, Integer quantity, Long productId, Orders orders) {
        this.id = id;
        this.quantity = quantity;
        this.productId = productId;
        this.ordersId = orders.getId();
    }
}
