package com.medvedev.shop.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;

    String lastName;

    int age;



}
