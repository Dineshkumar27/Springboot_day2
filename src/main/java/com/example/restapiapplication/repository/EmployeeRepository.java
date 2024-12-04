package com.example.restapiapplication.repository;

import com.example.restapiapplication.entity.EmployeeEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {
//    List<EmployeeEntity> findByEmployeeName(String empName);

    List<EmployeeEntity> findByEmployeeNameLikeOrderByDepartment(String name);

    @Query(value = "select e from EmployeeEntity e where employeeName Like %:employeeName%",nativeQuery = true)
    List<EmployeeEntity> searchEmployeeByNameLike(String employeeName, Sort sort);
}
