package com.medvedev.shop.repository;


import com.medvedev.shop.model.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends CrudRepository<Purchase,Long> {
    @Override
    List<Purchase> findAll();

    @Override
    Optional<Purchase> findById(Long id);

    Optional<Purchase> findAllByPurchaseDateBetween(Date date,Date date2);


}
