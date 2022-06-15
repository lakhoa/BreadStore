package com.example.Miniproject_spring.controller;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/testproduct")
    public Product create(@RequestBody Product product)
    {
        return productService.create(product);
    }

    @GetMapping("/testgetproduct")
    public List<Product> get_all()
    {
        return productService.get_all();
    }
}
