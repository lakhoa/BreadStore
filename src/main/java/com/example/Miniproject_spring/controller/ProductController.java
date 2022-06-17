package com.example.Miniproject_spring.controller;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> productList() {
        List<Product> rs = productService.findAll();
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
