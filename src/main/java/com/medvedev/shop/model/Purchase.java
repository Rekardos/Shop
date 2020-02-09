package com.medvedev.shop.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    LocalDate purchaseDate;

    @ManyToMany
    @JoinTable(
            name = "products_purchases",
            joinColumns = {@JoinColumn(name = "purchase_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    List<Product> products = new ArrayList<>();
}
