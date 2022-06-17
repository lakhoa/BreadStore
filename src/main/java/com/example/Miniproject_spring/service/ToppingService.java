package com.example.Miniproject_spring.service;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.entity.Topping;

import java.util.List;

public interface ToppingService {
    List<Topping> findAllToppingByProductId (long id);

}
