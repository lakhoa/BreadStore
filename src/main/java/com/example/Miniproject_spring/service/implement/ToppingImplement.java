package com.example.Miniproject_spring.service.implement;

import com.example.Miniproject_spring.entity.Topping;
import com.example.Miniproject_spring.repository.ToppingRepository;
import com.example.Miniproject_spring.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToppingImplement implements ToppingService {
    @Autowired
    ToppingRepository toppingRepository;


    @Override
    public List<Topping> findAllToppingByProductId(long id) {
        return null;
    }
}
