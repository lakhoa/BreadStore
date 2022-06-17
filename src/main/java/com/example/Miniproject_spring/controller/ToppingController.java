package com.example.Miniproject_spring.controller;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.entity.Topping;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.repository.ToppingRepository;
import com.example.Miniproject_spring.service.ProductService;
import com.example.Miniproject_spring.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToppingController {

    }
     /*
    @GetMapping("/products/{id}")
    public ResponseEntity<List<Topping>> productList(@PathVariable long id) {
        List<Topping>  rs = toppingService.findAllByProduct(id);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }*/

