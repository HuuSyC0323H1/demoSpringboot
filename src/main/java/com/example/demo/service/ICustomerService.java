package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenernateService<Customer> {
    Page<Customer> searchAllBy(String keyword, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
    Long count();
}
