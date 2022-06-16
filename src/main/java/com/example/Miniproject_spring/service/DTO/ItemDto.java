package com.example.Miniproject_spring.service.DTO;

import com.example.Miniproject_spring.entity.Product;

public class ItemDto {
    Product product;
    Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemDto(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
