package com.example.Miniproject_spring.service.DTO;

import javax.validation.constraints.NotNull;

public class OrderToppingDto {

    private Long toppingId;
    @NotNull
    private Integer quantity;

    public OrderToppingDto()
    {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getToppingId() {
        return toppingId;
    }

    public void setToppingId(Long toppingId) {
        this.toppingId = toppingId;
    }

    public OrderToppingDto(Integer quantity, Long productId) {
        this.quantity = quantity;
        this.toppingId = productId;
    }
}
