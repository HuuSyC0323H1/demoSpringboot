package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select u from User u join u.customer c where u.username like %?1% or c.customerName like %?1%")
    Page<Customer> searchAllBy(String keyword, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
    @Query("SELECT count(*) AS total_orders FROM Customer")
    Long countCustomer();
}
