package com.medvedev.shop.entityes;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Orders {

    @Id
    long id;

    @ManyToMany
    List<Product> products = new ArrayList<>();


    int count;
    float amount;
    Date purchaseDate;

}
