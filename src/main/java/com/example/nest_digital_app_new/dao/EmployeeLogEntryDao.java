package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.EmployeeLogEntry;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeLogEntryDao extends CrudRepository<EmployeeLogEntry,Integer> {
}
