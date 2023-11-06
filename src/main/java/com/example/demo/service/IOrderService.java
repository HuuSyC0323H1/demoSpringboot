package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderService extends IGenernateService<Order> {
    Page<Order> findAll(Pageable pageable);

    Page<Order> searchAllBy(String keyword, Pageable pageable);

    Long count();
    List<Order> findTop5ByOrderByStartDayDesc(Pageable pageable);

}
