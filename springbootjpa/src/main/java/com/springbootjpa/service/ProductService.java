package com.springbootjpa.service;

import com.springbootjpa.domain.Product;
import com.springbootjpa.domain.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Resource(name = "productRepository")
    private ProductRepository productRepository;

    //
    public void save(Product product) {
        productRepository.save(product);
    }

    //
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}