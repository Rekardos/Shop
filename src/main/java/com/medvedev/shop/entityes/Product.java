package com.medvedev.shop.entityes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    String name;

    float price;
}
