package com.example.ems.controller;


import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public void createCollection(@RequestParam String collectionName) {
        employeeService.createCollection(collectionName);
    }

    @PostMapping("/index")
    public void indexData(@RequestBody List<Employee> employees, @RequestParam String excludeColumn) {
        employeeService.indexData(employees, excludeColumn);
    }

    @GetMapping("/search")
    public List<Employee> searchByColumn(@RequestParam String columnName, @RequestParam String columnValue) {
        return employeeService.searchByColumn(columnName, columnValue);
    }

    @GetMapping("/count")
    public long getEmpCount() {
        return employeeService.getEmpCount();
    }

    @DeleteMapping("/delete/{id}")
    public void delEmpById(@PathVariable String id) {
        employeeService.delEmpById(id);
    }

    @GetMapping("/facet")
    public Map<String, Long> getDepFacet() {
        return employeeService.getDepFacet();
    }
}
