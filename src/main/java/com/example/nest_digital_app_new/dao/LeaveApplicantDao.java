package com.example.nest_digital_app_new.dao;

import com.example.nest_digital_app_new.model.LeaveApplications;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveApplicantDao extends CrudRepository<LeaveApplications, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplications` SET `status` = :status WHERE `empid` = :empid",nativeQuery = true)
    void updateLeaveApplication(@Param("empid") Integer empid , @Param("status") Integer status);


    @Query(value = "SELECT `id`, `empid`, `end_date`, `leave_type`, `no_of_days`, `reason`, `start_date`, `status`, `applyingdate`, `updated` FROM `leaveapplications` WHERE `empid` LIKE %:empid%",nativeQuery = true)
    List<LeaveApplications> employeeViewStatus(@Param("empid") Integer empid);


    @Query(value = "SELECT `id`, `empid`, `end_date`, `leave_type`, `no_of_days`, `reason`, `start_date`, `status`, `applyingdate`, `updated` FROM `leaveapplications` WHERE `applyingdate` LIKE %:applyingdate%",nativeQuery = true)
    List<LeaveApplications> leaveViewsAdmin(@Param("applyingdate") String applyingdate);


    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplications` SET `status`= :status,`updated`= :updated WHERE `empid` = :empid",nativeQuery = true)
    void leaveStatusUpdate(@Param("empid") Integer empid, @Param("status") Integer status,@Param("updated") Integer updated);



}
