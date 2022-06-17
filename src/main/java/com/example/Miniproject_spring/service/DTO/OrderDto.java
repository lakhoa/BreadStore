package com.example.Miniproject_spring.service.DTO;

public class OrderDto<T>{
    long productId;
    T toppings;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    int quantity;

    public T getToppings() {
        return toppings;
    }

    public void setToppings(T toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDto(long idAdd, T item, int quantity) {
        this.productId = idAdd;
        this.toppings = item;
        this.quantity = quantity;
    }
}
