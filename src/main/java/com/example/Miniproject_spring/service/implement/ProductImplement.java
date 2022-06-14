package com.example.Miniproject_spring.service.implement;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImplement implements ProductService {
    private ProductRepository productRepository;

    public ProductImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return  productRepository.save(product);
    }

    @Override
    public List<Product> get_all() {
        List<Product> all = productRepository.findAll();
        return all;
    }
}
