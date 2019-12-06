package com.medvedev.shop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Orders {

    @Id
    long id;



    int count;
    float amount;
    Date purchaseDate;

}
