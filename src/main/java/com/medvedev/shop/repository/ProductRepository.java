package com.medvedev.shop.repository;

import com.medvedev.shop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    @Override
    List<Product> findAll();
}
