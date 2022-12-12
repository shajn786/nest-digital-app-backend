package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.LeaveCount;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveCount, Integer> {

}
