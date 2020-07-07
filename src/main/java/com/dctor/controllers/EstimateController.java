package com.dctor.Controllers;



import com.dctor.beans.Estimate;
import com.dctor.service.EstimateServiceImp;
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
public class EstimateController {

    @Autowired
    private EstimateServiceImp estimateService;

    @RequestMapping("/question_estimate")
    public String hall_index(){ return "question_estimate";}

    @RequestMapping("/getEstimate")
    @ResponseBody
    public Map<String,Object> getEstimate() {
        List<Consult> estimateList = estimateService.findAllestimate();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("estimateList",EstimateList);
        return map;
    }

    @RequestMapping("/findEstimate")
    @ResponseBody
    public Map<String,Object> findEstimate(Integer estimate_id) {
        Consult estimate = estimateService.findEstimateById(estimate_id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("estimate",estimate);
        return map;

    }

    @PostMapping("/updateEstimate")
    public String updateEstimate(HttpServletRequest request) {
        String answer=null,state=null;
        Integer ask_id=0;
        if(request.getParameter("estimate_suggest")!=null){
             answer = request.getParameter("estimate_suggest").toString();
             state = "评估完成";
        }
        if(request.getParameter("estimate_id")!=null){
            estimate_id = Integer.valueOf(request.getParameter("estimate_id").toString());
        }
        consultService.updateConsult(estimate_id,content,suggest,datetime);
        return "redirect:/question_estimate";

    }

}
