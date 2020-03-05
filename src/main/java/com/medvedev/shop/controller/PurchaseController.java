package com.medvedev.shop.controller;


import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.service.PurchaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping
    public List<Purchase> findAll() {
        return purchaseService.findAll();
    }

    @GetMapping("{id}")
    public Purchase findById(@PathVariable Long id) {
        return purchaseService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void create(@RequestBody Purchase purchase) {
        System.out.println(purchase);
        purchaseService.save(purchase);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        purchaseService.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Purchase purchaseFromDb, @RequestBody Purchase purchase) {
        BeanUtils.copyProperties(purchase, purchaseFromDb, "id");
        purchaseService.save(purchase);
    }

}
