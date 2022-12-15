package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.Employees;
import com.example.nest_digital_app_new.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {

    @Query(value="SELECT `id`, `address`, `mobno`, `password`, `scode`, `sname`, `username` FROM `security` WHERE `scode`= :scode",nativeQuery = true)
    List<Security> searchSecurity(@Param("scode") String scode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `security` WHERE `id`= :id",nativeQuery = true)
    void deleteSecurity(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `security` SET `address`= :address,`mobno`= :mobno,`sname`= :sname WHERE `id`= :id ",nativeQuery = true)
    void updateSecurity(@Param("id") Integer id,@Param("sname") String empname,@Param("address") String address
            ,@Param("mobno") String mobno);


    @Query(value = "SELECT `id`, `address`, `mobno`, `password`, `scode`, `sname`, `username` FROM `security` WHERE `username` = :username AND `password` =:password",nativeQuery = true)
    List<Security> securityAuth(@Param("username") String email,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `mobno`, `password`, `scode`, `sname`, `username` FROM `security` WHERE `id` = :id",nativeQuery = true)
    List<Security>securityDetails(@Param("id") Integer id);


}

