package com.dctor.controllers;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControllers {

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){return "HELLO WORLD!!!";}

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
