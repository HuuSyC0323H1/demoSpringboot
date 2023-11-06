package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "name")
    private String name;

    @Column(name = "task")
    private String task;

    @Column(name = "starts_time")
    private LocalDate startsTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "job")
    private Calendar calendar;

}
