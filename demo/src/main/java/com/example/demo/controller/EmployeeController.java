package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apis")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    Iterable<Employee> findAll(){
        return employeeService.getEmployee();
    }

    @PostMapping("/create")
    Employee createEmployee(@RequestBody  Employee employee){
       return employeeService.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id)
    {
       return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }

}
