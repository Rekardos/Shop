package com.medvedev.shop.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@XmlRootElement(name = "Purchase")
@XmlAccessorType(XmlAccessType.FIELD)
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    int age;
    int count;
    float amount;

    LocalDateTime purchaseDate;

    @ManyToMany
    @JoinTable(
            name = "products_purchases",
            joinColumns = {@JoinColumn(name = "purchase_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    List<Product> products = new ArrayList<>();
}