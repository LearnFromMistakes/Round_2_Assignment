package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepo extends ElasticsearchRepository<Employee,Long> {
}
