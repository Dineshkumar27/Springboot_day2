package com.example.restapiapplication.service;

import com.example.restapiapplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String empId);
}
