package com.example.Miniproject_spring.service.DTO;

import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.Product;

import javax.validation.constraints.NotNull;

public class OrdersDetailDto {
    @NotNull
    private Integer quantity;
    private Long productId;

    public OrdersDetailDto()
    {
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

    public OrdersDetailDto( Integer quantity, Long productId) {
        this.quantity = quantity;
        this.productId = productId;
    }
}
