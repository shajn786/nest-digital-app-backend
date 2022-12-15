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
    private long casual_leave;
    private long sick_leave;
    private long special_leave;

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

    public long getCasual_leave() {
        return casual_leave;
    }

    public void setCasual_leave(long casual_leave) {
        this.casual_leave = this.casual_leave-casual_leave;
    }

    public long getSick_leave() {
        return sick_leave;
    }

    public void setSick_leave(long sick_leave) {
        this.sick_leave = this.sick_leave-sick_leave;
    }

    public long getSpecial_leave() {
        return special_leave;
    }

    public void setSpecial_leave(long special_leave) {
        this.special_leave = this.special_leave- special_leave;
    }
}
