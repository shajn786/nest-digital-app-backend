package com.example.nest_digital_app_new.controller;

import com.example.nest_digital_app_new.dao.EmployeeDao;
import com.example.nest_digital_app_new.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class NestController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(value = "*")
    @PostMapping(path="/add", consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addEmployee(@RequestBody Employees e)
    {
        System.out.println(e.getEmpcode());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        dao.save(e);


        return map;
    }




}
