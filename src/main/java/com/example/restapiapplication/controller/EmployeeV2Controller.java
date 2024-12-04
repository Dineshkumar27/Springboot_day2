package com.example.restapiapplication.controller;

import com.example.restapiapplication.entity.EmployeeEntity;
import com.example.restapiapplication.model.Employee;
import com.example.restapiapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {
    @Qualifier("employeV2Impl")
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees(){

       return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
      return  employeeService.save(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String employeeId){

        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String empId){
        return employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/name/{empname}")
    public List<Employee> getEmployeeByName(@PathVariable("empname") String name){
        return employeeService.findByEmployeeNameLikeOrderByDepartment(name);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployeeByNameLike(@RequestParam("empname") String name, Sort sort){
        return employeeService.searchEmployeeByNameLike(name,sort);
    }
}
