package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "address")
    private String address;

    @Column(name = "day_nhap")
    private LocalDate dayNhap;

    @Column(name = "information")
    private String information;

}
