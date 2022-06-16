package com.example.Miniproject_spring.repository;
import com.example.Miniproject_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findById(long id);
    List<Product> findByIdIn(List<Long> ids);
}
