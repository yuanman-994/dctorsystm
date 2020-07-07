package com.dctor.service;

import com.dctor.beans.Estimate;

import java.util.List;
import java.util.Map;

public interface EstimateService {

    public List<Estimate> findAllEstimate();

    public int addEstimate(Estimate estimate);

        public int updateEstimate(Integer estimate_id,String estimate_content,String estimate_suggest,String estimate_datetime);

    public Estimate findEstimateById(Integer estimate_id);

    public Map<String,Object> searchEstimate(Integer estimate_doctor,Integer estimate_oldman,String estimate_healthy);
}
