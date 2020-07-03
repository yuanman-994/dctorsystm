package com.dctor.service;


import com.dctor.beans.Consult;
import com.dctor.mapper.ConsultMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultServiceImp implements ConsutService{

    @Resource
    private ConsultMapper consultMapper;


    @Override
    public List<Consult> findAllConsult() {
        return consultMapper.findAllConsult();
    }

    @Override
    public int addConsult(Consult consult) {
        consultMapper.addConsult(consult);
        return 0;
    }

    @Override
    public int updateConsult(Integer ask_id,String ask_answer,String ask_state) {
        consultMapper.updateConsult(ask_id,ask_answer,ask_state);
        return 0;
    }

    @Override
    public Consult findConsultById(Integer ask_id) {
        return consultMapper.findConsultById(ask_id);
    }

    @Override
    public Map<String,Object> searchConsults(String oldman_name, String select_date, String select_status) {
        List<Consult> consultList = consultMapper.searchConsults(oldman_name, select_date, select_status);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("consultList",consultList);
        return map;
    }
}
