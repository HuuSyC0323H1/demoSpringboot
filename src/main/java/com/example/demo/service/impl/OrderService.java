package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepositiry;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private final OrderRepositiry orderRepositiry;

    public OrderService(OrderRepositiry orderRepositiry) {
        this.orderRepositiry = orderRepositiry;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepositiry.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepositiry.save(order);
    }

    @Override
    public Optional<Order> findbyID(Long id) {
        return orderRepositiry.findById(id);
    }


    @Override
    public void delete(Long id) {
        orderRepositiry.deleteById(id);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepositiry.findAll(pageable);
    }

    @Override
    public Page<Order> searchAllBy(String keyword, Pageable pageable) {
        return orderRepositiry.searchAllBy(keyword,pageable);
    }

    @Override
    public Long count() {
        return orderRepositiry.count();
    }
    @Override
    public List<Order> findTop5ByOrderByStartDayDesc(Pageable pageable) {
        return orderRepositiry.findTop5ByOrderByStartDayDesc(pageable);
    }
}
