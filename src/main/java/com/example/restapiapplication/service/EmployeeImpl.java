package com.example.restapiapplication.service;

import com.example.restapiapplication.error.EmployeeNotFoundException;
import com.example.restapiapplication.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeImpl implements EmployeeService{

    List<Employee> employees=new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeId()==null||
        employee.getEmail().isEmpty()){
            employee.setEmployeId(UUID.randomUUID().toString());

        }
        employees.add(employee);
        return  employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeId().equals(employeeId))
                .findFirst()
                .orElseThrow(()->new RuntimeException("No Employee Found with id "+employeeId));
    }

    @Override
    public String deleteEmployeeById(String empId) {
        Employee employee= employees
                .stream()
                .filter(emp->emp.getEmployeId().equalsIgnoreCase(empId))
                .findFirst()
                .get();

        employees.remove(employee);
        return "deleted "+employee.getEmployeId();
    }

    @Override
    public List<Employee> findByEmployeeNameLikeOrderByDepartment(String name) {
        return List.of();
    }

    @Override
    public List<Employee> searchEmployeeByNameLike(String name, Sort sort) {
        return List.of();
    }


}
