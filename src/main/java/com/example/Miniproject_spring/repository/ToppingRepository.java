package com.example.Miniproject_spring.repository;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {
    List<Topping> findByIdIn(List<Long> ids);
}
