package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    @Query("select u from User u join u.department c where u.username like %?1% or c.departmentName like %?1%")
    Page<Department> searchAllBy(String keyword, Pageable pageable);

    Page<Department> findAll(Pageable pageable);
}
