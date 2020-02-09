package com.medvedev.shop.service;

import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElseThrow();
    }

    public List<Purchase> findAll() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }

    public void save(Purchase purchase) {
        purchase.setPurchaseDate(LocalDate.now());
        purchaseRepository.save(purchase);
    }
}
