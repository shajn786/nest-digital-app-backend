package com.example.nest_digital_app_new.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leavecounts")
public class LeaveCount {


    @Id
    @GeneratedValue
    private int id;
    private String empid;
    private String year;
    private int casual_leave;
    private int sick_leave;
    private int special_leave;

    public LeaveCount() {
    }

    public LeaveCount(int id, String empid, String year) {
        this.id = id;
        this.empid = empid;
        this.year = year;
        this.casual_leave = casual_leave;
        this.sick_leave = sick_leave;
        this.special_leave = special_leave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCasual_leave() {
        return casual_leave;
    }

    public void setCasual_leave(int casual_leave) {
        this.casual_leave = casual_leave;
    }

    public int getSick_leave() {
        return sick_leave;
    }

    public void setSick_leave(int sick_leave) {
        this.sick_leave = sick_leave;
    }

    public int getSpecial_leave() {
        return special_leave;
    }

    public void setSpecial_leave(int special_leave) {
        this.special_leave = special_leave;
    }
}
