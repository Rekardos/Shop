package com.medvedev.shop.service;


import com.medvedev.shop.model.Product;
import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.repository.ProductRepository;
import com.medvedev.shop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findProductToPurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        return purchase.getProducts();
    }
}
