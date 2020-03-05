package com.medvedev.shop.repository;


import com.medvedev.shop.model.Purchase;
import org.springframework.data.repository.CrudRepository;


public interface PurchaseRepository extends CrudRepository<Purchase,Long> {
}