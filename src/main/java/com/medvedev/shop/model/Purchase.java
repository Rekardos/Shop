package com.medvedev.shop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    int age;
    int count;
    float amount;
    Date purchaseDate;

    public Purchase() {
    }

    public Purchase(String name, String lastName, int age, int count, float amount) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
        this.amount = amount;
    }

    public Purchase(Long id, String name, String lastName, int age, int count, float amount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
        this.amount = amount;
    }

    @ManyToMany
            @JoinTable(
                name = "products_purchases",
                joinColumns = {@JoinColumn(name = "purchase_id")},
                inverseJoinColumns = {@JoinColumn(name = "product_id")}
            )
    List<Product> products = new ArrayList<>();



}
