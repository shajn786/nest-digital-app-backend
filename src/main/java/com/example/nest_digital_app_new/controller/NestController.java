package com.example.nest_digital_app_new.controller;

import com.example.nest_digital_app_new.dao.EmployeeDao;
import com.example.nest_digital_app_new.dao.LeaveDao;
import com.example.nest_digital_app_new.dao.SecurityDao;
import com.example.nest_digital_app_new.model.Employees;
import com.example.nest_digital_app_new.model.LeaveApplications;
import com.example.nest_digital_app_new.model.LeaveCount;
import com.example.nest_digital_app_new.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class NestController {

    @Autowired
    private EmployeeDao dao;

    @Autowired
    private LeaveDao ldao;

    @Autowired
    private SecurityDao sdao;

    @CrossOrigin(value = "*")
    @PostMapping(path="/addemp", consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addEmployee(@RequestBody Employees e)
    {
        System.out.println(e.getEmpcode());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        dao.save(e);


        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/leavecount", consumes = "application/json",produces = "application/json")
    public HashMap<String,String> leaveCount(@RequestBody LeaveCount l)
    {
        System.out.println(l.getCasual_leave());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        l.setCasual_leave(20);

        l.setSick_leave(3);
        l.setSpecial_leave(7);
        ldao.save(l);




        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/searchemp", produces = "application/json", consumes = "application/json")
    public List<Employees> productSearch(@RequestBody Employees e)
    {
        String empcode = e.getEmpcode();

        return (List<Employees>) dao.searchEmployee(e.getEmpcode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeedelete",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> employeeDelete(@RequestBody Employees e)
    {
        String id = String.valueOf(e.getId());
        System.out.println(id);
        dao.deleteEmployee(e.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeeupdate",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> employeeUpdate(@RequestBody Employees e)
    {
        String id = String.valueOf(e.getId());
        System.out.println(id);
        dao.updateEmployee(e.getId(),e.getEmpname(),e.getAddress(),e.getEmail(),e.getMobno());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(value = "*")
    @PostMapping(path="/addsecurity", consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addSecurity(@RequestBody Security s)
    {
        System.out.println(s.getScode());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        sdao.save(s);


        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/searchsecurity", produces = "application/json", consumes = "application/json")
    public List<Security> searchSecurity(@RequestBody Security s)
    {
        System.out.println(s.getScode());

        return (List<Security>) sdao.searchSecurity(s.getScode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/securitydelete",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityDelete(@RequestBody Security s)
    {
        String id = String.valueOf(s.getId());
        System.out.println(id);
        sdao.deleteSecurity(s.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path="/securityupdate",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityUpdate(@RequestBody Security s)
    {
        String id = String.valueOf(s.getId());
        System.out.println(id);
        sdao.updateSecurity(s.getId(),s.getSname(),s.getAddress(),s.getMobno());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/leavapplication",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityUpdate(@RequestBody LeaveApplications la)
    {

        System.out.println(la.getNo_of_days());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    }





