package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IUserSerive extends IGenernateService<User> {
    Page<User> findAll(Pageable pageable);
    Page<User> searchAllBy(String keyword, Pageable pageable);
    List<User> findUsersByUsernameContaining(String name);
}
