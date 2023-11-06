package com.example.demo.service;


import com.example.demo.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService extends IGenernateService<Department>{
    Page<Department> findAll(Pageable pageable);
    Page<Department> searchAllBy(String keyword, Pageable pageable);
}
