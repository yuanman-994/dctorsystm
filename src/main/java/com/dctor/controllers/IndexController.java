package com.dctor.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dctor.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping("/index/getOldMenNum")
    @ResponseBody
    public int getOldMenNum(){//关联老人统计

        int docId = 1;

        return indexService.getOldMenNum(docId);
    }

    @GetMapping("/index/getAdvisoryData")
    @ResponseBody
    public String getAdvisoryData(){//资询用户统计
        int docId = 1;
        return indexService.getAdvisoryData(docId);
    }
}
