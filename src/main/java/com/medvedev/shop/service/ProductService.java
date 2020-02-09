package com.medvedev.shop.service;


import com.medvedev.shop.model.Product;
import com.medvedev.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

}
