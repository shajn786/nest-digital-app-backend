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
    private int status;
    private long no_of_days;
    private String leaveType;
    private String reason;
    private int updated;

    private String applyingdate;

    public LeaveApplications() {
    }

    public LeaveApplications(int id, int empid, String start_date, String end_date, int status, long no_of_days, String leaveType, String reason, int updated, String applyingdate) {
        this.id = id;
        this.empid = empid;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.no_of_days = no_of_days;
        this.leaveType = leaveType;
        this.reason = reason;
        this.updated = updated;
        this.applyingdate = applyingdate;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(long no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public String getApplyingdate() {
        return applyingdate;
    }

    public void setApplyingdate(String applyingdate) {
        this.applyingdate = applyingdate;
    }
}
