package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employees, Integer> {
}
