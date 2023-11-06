package com.example.demo.service.impl;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll() ;
    }

    @Override
    public Optional<Job> findbyID(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public Page<Job> searchAllBy(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Long countJob() {
        return jobRepository.countJob();
    }

    @Override
    public List<Job> findTop5Job(Pageable pageable) {
        return jobRepository.findTop5ByOrderByEndTimeAsc(pageable);
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
