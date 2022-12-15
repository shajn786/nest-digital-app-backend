package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.VisitorLogEntry;
import org.springframework.data.repository.CrudRepository;

public interface VisitorLogDao extends CrudRepository<VisitorLogEntry, Integer> {
}
