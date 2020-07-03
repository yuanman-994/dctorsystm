package com.dctor.service;

import com.dctor.beans.Consult;

import java.util.List;
import java.util.Map;

public interface ConsutService {

    public List<Consult> findAllConsult();

    public int addConsult(Consult consult);

    public int updateConsult(Integer ask_id,String ask_answer,String ask_state);

    public Consult findConsultById(Integer ask_id);

    public Map<String,Object> searchConsults(String oldman_name, String select_date, String select_status);
}
