package com.example.Miniproject_spring.models;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.entity.Topping;

import java.util.List;

public class ProductResponse {
    long id;
    String name;
    double price;
    int maxTopping;
    List<Topping> listTopping;

    public ProductResponse(long id, String name, double price, int maxTopping, List<Topping> listTopping) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxTopping = maxTopping;
        this.listTopping = listTopping;
    }
}
