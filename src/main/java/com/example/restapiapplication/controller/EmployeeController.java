package com.example.restapiapplication.controller;


import com.example.restapiapplication.model.Employee;
import com.example.restapiapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){

       return employeeService.save(employee);


    }
    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String employeeId){

        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String empId){
        return employeeService.deleteEmployeeById(empId);
    }



}
