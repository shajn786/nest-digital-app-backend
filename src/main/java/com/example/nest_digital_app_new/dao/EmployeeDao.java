package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees, Integer> {

    @Query(value="SELECT `id`, `address`, `email`, `empcode`, `empname`, `mobno`, `password`, `username` FROM `employees` WHERE `empcode`= :empcode",nativeQuery = true)
    List<Employees> searchEmployee(@Param("empcode") String empcode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employees` WHERE `id` = :id",nativeQuery = true)
    void deleteEmployee(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `employees` SET `address`= :address,`email`= :email,`empname`= :empname,`mobno`= :mobno WHERE `id`= :id",nativeQuery = true)
    void updateEmployee(@Param("id") Integer id,@Param("empname") String empname,@Param("address") String address,@Param("email") String email
    ,@Param("mobno") String mobno);
}
