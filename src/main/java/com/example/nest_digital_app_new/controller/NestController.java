package com.example.nest_digital_app_new.controller;

import com.example.nest_digital_app_new.dao.*;
import com.example.nest_digital_app_new.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



@RestController
public class NestController {

    @Autowired
    private EmployeeDao dao;

    @Autowired
    private LeaveDao ldao;

    @Autowired
    private SecurityDao sdao;

    @Autowired
    private LeaveApplicantDao ladao;

    @Autowired
    private VisitorLogDao vdao;

    @Autowired
    private EmployeeLogEntryDao eldao;

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

    //leave application data entry
    @CrossOrigin(origins = "*")
    @PostMapping(path="/leavapplication",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityUpdate(@RequestBody LeaveApplications la)
    {
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String todaydate = dtf.format(now);

        try
        {
            Date date1 = obj.parse(la.getStart_date());
            Date date2 = obj.parse(la.getEnd_date());
            long time_difference = date2.getTime() - date1.getTime();
            long days_difference = (time_difference / (1000*60*60*24)) % 365;
            la.setNo_of_days(days_difference+1);
            la.setApplyingdate(todaydate);
            ladao.save(la);



        }
        catch (ParseException excep) {
            excep.printStackTrace();
        }
        System.out.println(la.getNo_of_days());
        HashMap<String,String> map = new HashMap<>();
        ladao.save(la);
        map.put("status","success");
        return map;


    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/visitorlogentry",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> visitorLogEntry(@RequestBody VisitorLogEntry v)
    {
        System.out.println(v.getName());
        vdao.save(v);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeelogentry",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> employeeLogEntry(@RequestBody EmployeeLogEntry ele)
    {


        System.out.println(ele.getEmpcode());
        eldao.save(ele);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/leaveapplicationupdate",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> updateLeaveApplication(@RequestBody  LeaveApplications la)
    {
        System.out.println(la.getStatus());
        ladao.updateLeaveApplication(la.getEmpid(),la.getStatus());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path="/employeeviewstatus",consumes = "application/json", produces ="application/json")
//    public HashMap<String,String> employeeViewStatus(@RequestBody LeaveApplications la, LeaveCount lc)
//    {
//        System.out.println(la.getEmpid());
//        List<LeaveApplications> result = (List<LeaveApplications>) ladao.employeeViewStatus(la.getEmpid());
//        HashMap<String,String> map = new HashMap<>();
//        if(result.get(0).getStatus() == 0)
//        {
//            map.put("status","applied");
//        } else if (result.get(0).getStatus() == 1) {
//            map.put("status","approved");
//            String leavetype = result.get(0).getLeaveType();
//            System.out.println(result.get(0).getLeaveType());
//            if(leavetype == "casual" )
//            {
//                System.out.println("sssssssssss");
//                lc.setCasual_leave(la.getNo_of_days());
//
//            } else if (leavetype.equals("sick_leave")) {
//                  lc.setSick_leave(la.getNo_of_days());
//            } else if (leavetype.equals("special_leave")) {
//                 lc.setSpecial_leave(la.getNo_of_days());
//            }
//
//        } else if (result.get(0).getStatus()== -1) {
//            map.put("status","rejected");
//        }
//        System.out.println(lc.getCasual_leave());
//        return map;
//    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeeauth",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> employeeAuth(@RequestBody  Employees e)
    {

        List<Employees> result = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        result = (List<Employees>) dao.employeeAuth(e.getEmail(),e.getPassword()) ;
        if(result.size()==0)
        {

            map.put("failed","invalid credential");
        }
        else {
            int id = result.get(0).getId();
            map.put("status","success");
            map.put("empid", String.valueOf(id));
        }
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/securityauth",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityAuth(@RequestBody  Security s)
    {

        List<Security> result = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        result = (List<Security>) sdao.securityAuth(s.getUsername(),s.getPassword()) ;
        if(result.size()==0)
        {

            map.put("failed","invalid credential");
        }
        else {
            int id = result.get(0).getId();
            map.put("status","success");
            map.put("sid", String.valueOf(id));
        }

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallemployee")
    public List<Employees> viewallEmployee()
    {

        return (List<Employees>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallSecurity")
    public List<Security> viewallSecurity()
    {

        return (List<Security>) sdao.findAll();
    }

    @CrossOrigin(value = "*")
    @PostMapping(path ="/employeeDetails", consumes = "application/json", produces = "application/json")
    public List<Employees> userDetails(@RequestBody Employees e)
    {
        return (List<Employees>) dao.employyeDetails(e.getId());
    }

    @CrossOrigin(value = "*")
    @PostMapping(path ="/empleavestatus", consumes = "application/json", produces = "application/json")
    public List<LeaveApplications> employeLeaveStatus (@RequestBody LeaveApplications la)
    {

        return  (List<LeaveApplications>) ladao.employeeViewStatus(la.getEmpid());


    }

    @CrossOrigin(value = "*")
    @PostMapping(path ="/securitydetails", consumes = "application/json", produces = "application/json")
    public List<Security> userDetails(@RequestBody Security s)
    {
        return (List<Security>) sdao.securityDetails(s.getId());
    }

    @CrossOrigin(value = "*")
    @PostMapping(path ="/leaveSearchAdmin", consumes = "application/json", produces = "application/json")
    public  List<LeaveApplications> adminLeaveSearch(@RequestBody LeaveApplications la)
    {

          return (List<LeaveApplications>) ladao.leaveViewsAdmin(la.getApplyingdate());

    }

    @CrossOrigin(value = "*")
    @PostMapping(path ="/leaveupdateStatus", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> adminUpdateLeaveStatus(@RequestBody LeaveApplications la)
    {
        HashMap<String,String> map = new HashMap<>();
        ladao.leaveStatusUpdate(la.getEmpid(),la.getStatus(),la.getUpdated());
        map.put("status","success");
        return map;


    }



}





