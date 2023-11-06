package com.example.demo.service;

import com.example.demo.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IJobService extends IGenernateService<Job> {
    Page<Job> findAll(Pageable pageable);
    Page<Job> searchAllBy(String keyword, Pageable pageable);
    Long countJob();

    List<Job> findTop5Job(Pageable pageable);
}
