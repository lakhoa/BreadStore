package com.example.Miniproject_spring.service;

import com.example.Miniproject_spring.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    List<Product> get_all();

    Product findById(Long productId);

}
