package com.dctor.service;


import com.dctor.beans.Estimate;
import com.dctor.mapper.EstimateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstimateServiceImp implements EstimateService{

    @Resource
    private EstimateMapper estimateMapper;


    @Override
    public List<Consult> findAllEstimate() {
        return estimateMapper.findAllEstimate();
    }

    @Override
    public int addEstimate(EStimate estimate) {
        estimateMapper.addEstimate(estimate);
        return 0;
    }

    @Override
    public int updateEstimate(Integer estimate_id,String estimate_content,String estimate_suggest,String estimate_datetime) {
        estimateMapper.updateEstimate(estimate_id,estimate_content,estimate_suggest,estimate_datetime);
        return 0;
    }

    @Override
    public Estimate findEstimateById(Integer estimate_id) {
        return estimateMapper.findEstimateById(estimate_id);
    }
    
}
