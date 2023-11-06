package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
//    @Query("select u from User u join u.customer c where u.username like %?1% or c.customerName like %?1%")
    Page<Job> searchAllBy(String keyword, Pageable pageable);

    Page<Job> findAll(Pageable pageable);

    @Query("SELECT count(*) AS total_orders FROM Job")
    long countJob();

    List<Job> findTop5ByOrderByEndTimeAsc(Pageable pageable);
}
