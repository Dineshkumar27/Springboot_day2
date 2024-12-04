package com.example.restapiapplication.service;

import com.example.restapiapplication.entity.EmployeeEntity;
import com.example.restapiapplication.model.Employee;
import com.example.restapiapplication.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeV2Impl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeId()==null||
                employee.getEmail().isEmpty()){
            employee.setEmployeId(UUID.randomUUID().toString());

        }

        EmployeeEntity entity=new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);


        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();

        List<Employee> employeeList=
                employeeEntityList
                        .stream()
                        .map(employeeEntity -> {
                            Employee employee=new Employee();
                            BeanUtils.copyProperties(employeeEntity,employee);
                            return employee;
                        }).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee ;
    }

    @Override
    public String deleteEmployeeById(String empId) {
        employeeRepository.deleteById(empId);
        return empId+" has been deleted";

    }

    @Override
    public List<Employee> findByEmployeeNameLikeOrderByDepartment(String name) {
        List<EmployeeEntity> employeeEntityList=employeeRepository.findByEmployeeNameLikeOrderByDepartment(name);

        List<Employee> employeeList=
                employeeEntityList
                        .stream()
                        .map(employeeEntity -> {
                            Employee employee=new Employee();
                            BeanUtils.copyProperties(employeeEntity,employee);
                            return employee;
                        }).collect(Collectors.toList());
        return employeeList;

    }

    @Override
    public List<Employee> searchEmployeeByNameLike(String name, Sort sort) {
        List<EmployeeEntity> employeeEntityList=employeeRepository.searchEmployeeByNameLike(name,Sort.by("employeeName"));
//       Pageable<Employee> allPages=employeeRepository.findAll(Pageable.ofSize(2)).getTotalElements()
//       allPages.getTotalpage()
//               allPages.getTotalPages
        List<Employee> employeeList=
                employeeEntityList
                        .stream()
                        .map(employeeEntity -> {
                            Employee employee=new Employee();
                            BeanUtils.copyProperties(employeeEntity,employee);
                            return employee;
                        }).collect(Collectors.toList());
        return employeeList;

    }


}
