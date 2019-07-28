package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;


public interface EmployeeDao extends JpaRepository<Employee,Integer> {

 List<Employee> findByempNoGreaterThan(int i);

List<Employee> findByempName(String string);


}
	