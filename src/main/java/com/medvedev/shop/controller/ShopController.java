package com.medvedev.shop.controller;


import com.medvedev.shop.model.Product;
import com.medvedev.shop.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ShopController  {


    ProductRepository productRepository;

    public ShopController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public String getAllProducts (Model model) {
        List<Product> product = productRepository.findAll();
        model.addAttribute("product",product);
      return "products";

    }


}
