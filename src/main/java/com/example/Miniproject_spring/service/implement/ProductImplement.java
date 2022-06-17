package com.example.Miniproject_spring.service.implement;

import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.models.ProductResponse;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.service.ProductService;
import com.example.Miniproject_spring.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;

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

    @Override
    public Product findById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty())
        {
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
