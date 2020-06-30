package com.dctor.controllers;
import com.dctor.beans.Doctor;
import com.dctor.beans.Oldman;
import com.dctor.mapper.DoctorMapper;
import com.dctor.mapper.OldmanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HelloControllers {


    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private OldmanMapper oldmanMapper;
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){return "HELLO WORLD!!!";}

    @GetMapping("/doctor")
    public String toDoctor(HttpServletRequest request, Model model, HttpSession session) {
        int doctor_id = 1;
        Doctor me = doctorMapper.findDoctorById(doctor_id);
        System.out.println(me.getDoctor_name());
        List<Oldman> my = oldmanMapper.findOldmanByDoctor(doctor_id);
        model.addAttribute("oldmanList", my);
        model.addAttribute("info", me);
        return "doctor";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/assessment")
    public String assessment() {
        return "assessment";
    }
    @RequestMapping("/assessment_give")
    public String assessment_give() {
        return "assessment_give";
    }

}
