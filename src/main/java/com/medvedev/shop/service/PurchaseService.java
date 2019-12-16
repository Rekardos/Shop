package com.medvedev.shop.service;

import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElseThrow();
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }

    public void create(String name,String lastName,int age,int count,float amount) {
        purchaseRepository.save(new Purchase(name,lastName,age,count,amount));
    }

    public void updatePurchase(Purchase purchase) {
        purchaseRepository.findById(1L);
        purchaseRepository.save(purchase);
    }
}
