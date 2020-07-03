package com.dctor.controllers;


import com.dctor.beans.Consult;
import com.dctor.service.ConsultServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ConsultController {

    @Autowired
    private ConsultServiceImp consultService;

    @RequestMapping("/question_consult")
    public String hall_index(){ return "question_consult";}

    @RequestMapping("/getConsult")
    @ResponseBody
    public Map<String,Object> getConsult() {
        List<Consult> consultList = consultService.findAllConsult();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("consultList",consultList);
        return map;
    }

    @RequestMapping("/findConsult")
    @ResponseBody
    public Map<String,Object> findConsult(Integer ask_id) {
        Consult consult = consultService.findConsultById(ask_id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("consult",consult);
        return map;

    }

    @PostMapping("/updateConsult")
    public String updateConsult(HttpServletRequest request) {
        String answer=null,state=null;
        Integer ask_id=0;
        if(request.getParameter("ask_answer")!=null){
             answer = request.getParameter("ask_answer").toString();
             state = "已回复";
        }
        if(request.getParameter("ask_id")!=null){
             ask_id = Integer.valueOf(request.getParameter("ask_id").toString());
        }
        consultService.updateConsult(ask_id,answer,state);
        return "redirect:/question_consult";

    }


    @RequestMapping("/searchConsult")
    @ResponseBody
    public Map<String,Object> searchConsult(@RequestBody Map<String,Object> params) {
        String oldman_name;
        String search_content = params.get("search_content").toString();
        String ask_time = params.get("search_date").toString();
        String ask_status =  params.get("search_status").toString();
        Map<String, Object> map = new HashMap<String, Object>();
        if(search_content!=null){
            oldman_name = search_content;
            map = consultService.searchConsults(oldman_name,ask_time,ask_status);
        }
        return map;
    }

}
