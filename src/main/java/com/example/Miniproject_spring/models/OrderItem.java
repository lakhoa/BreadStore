package com.example.Miniproject_spring.models;

import com.example.Miniproject_spring.entity.Product;

public class OrderItem {
    Product product;
    long quantity;

    public OrderItem(Product product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
