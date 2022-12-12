package com.example.nest_digital_app_new.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaveapplications")
public class LeaveApplications {

    @Id
    @GeneratedValue
    private int id;

    private int empid;
    private String start_date;
    private String end_date;
    private String status;
    private String no_of_days;

    public LeaveApplications() {
    }

    public LeaveApplications(int id, int empid, String start_date, String end_date, String status, String no_of_days) {
        this.id = id;
        this.empid = empid;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.no_of_days = no_of_days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(String no_of_days) {
        this.no_of_days = no_of_days;
    }
}
