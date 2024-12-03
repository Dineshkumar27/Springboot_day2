package com.example.restapiapplication.controller;

import com.example.restapiapplication.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {
    @GetMapping
    public String getAllEmployees(){

        return "From V2 Employee Controller";
    }
}
