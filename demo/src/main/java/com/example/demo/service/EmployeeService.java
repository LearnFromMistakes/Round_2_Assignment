package com.example.demo.service;


import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Iterable<Employee> getEmployee(){
        return employeeRepo.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee,Long id){
        Employee employee1 = employeeRepo.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setPhone(employee.getPhone());
        employee1.setGender(employee.getGender());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepo.save(employee1);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

}
