package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepositiry extends JpaRepository<Order, Long> {
    @Query("select u from User u join u.customer c where u.username like %?1% or c.customerName like %?1%")
    Page<Order> searchAllBy(String keyword, Pageable pageable);

    Page<Order> findAll(Pageable pageable);

    @Query("SELECT count(*) AS total_orders FROM Order")
    long count();
    List<Order> findTop5ByOrderByStartDayDesc(Pageable pageable);

}
