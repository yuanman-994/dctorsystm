package com.dctor.service;


import com.dctor.beans.Estimate;
import com.dctor.mapper.EstimateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EstimateServiceImp implements EstimateService {

    @Resource
    private EstimateMapper estimateMapper;


    @Override
    public List<Estimate> findAllEstimate() {
        return estimateMapper.findAllEstimate();
    }

    @Override
    public int addEstimate(Estimate estimate) {
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

    @Override
    public Map<String, Object> searchEstimate(Integer estimate_doctor, Integer estimate_oldman, String estimate_healthy) {
        return null;
    }

    public List<Estimate> findAllestimate() {
        return null;
    }

    public void updateEstimate(Integer estimate_id, String content, String suggest) {
    }
}
