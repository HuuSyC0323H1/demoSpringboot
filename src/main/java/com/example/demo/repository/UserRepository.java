package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join u.customer c where u.username like %?1% or c.customerName like %?1%")
    Page<User> searchAllBy(String keyword, Pageable pageable);

    Page<User> findAll(Pageable pageable);
    List<User> findUsersByUsernameContaining(String name);
}
