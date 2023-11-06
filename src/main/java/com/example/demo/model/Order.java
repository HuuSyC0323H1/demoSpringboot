package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "name_order")
    private String nameOrder;

    @Column(name = "name_gui")
    private String nameGui;

    @Column(name = "name_nhan")
    private String nameNhan;

    @Column(name = "start_day")
    private LocalDate startDay;

    @Column(name = "address_to")
    private String addressTo;

    @Column(name = "address_from")
    private String addressFrom;

    @Column(name = "price")
    private float price;

    @Column(name = "tax")
    private float tax;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
