package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private Long mailId;

    @Column(name = "name_mail")
    private String nameMail;

    @Column(name = "password")
    private String password;

}
