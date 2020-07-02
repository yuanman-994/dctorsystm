package com.dctor.service;

import org.springframework.stereotype.Service;

@Service
public interface IndexService {
    public int getOldMenNum(int docId);

    //data{
    // num:[...]  当日资讯人数
    // date:[...] 日期
    //}
    public String getAdvisoryData(int docId);
}
