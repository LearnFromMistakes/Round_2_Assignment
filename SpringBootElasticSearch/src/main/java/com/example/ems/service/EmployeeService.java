package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void createCollection(String collectionName) {
        // Elasticsearch automatically creates indices when documents are indexed
    }

    public void indexData(List<Employee> employees, String excludeColumn) {
        if ("department".equalsIgnoreCase(excludeColumn)) {
            employees.forEach(employee -> employee.setDepartment(null));
        } else if ("gender".equalsIgnoreCase(excludeColumn)) {
            employees.forEach(employee -> employee.setGender(null));
        }
        employeeRepository.saveAll(employees);
    }

    public List<Employee> searchByColumn(String columnName, String columnValue) {
        // Implement search logic based on column name and value
        // This is a simplified example, you might need to use custom queries for dynamic searches
        return (List<Employee>) employeeRepository.findAll();
    }

    public long getEmpCount() {
        return employeeRepository.count();
    }

    public void delEmpById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Map<String, Long> getDepFacet() {
        // Implement logic to retrieve count of employees grouped by department
        return (Map<String, Long>) employeeRepository.findAll();
    }
}

