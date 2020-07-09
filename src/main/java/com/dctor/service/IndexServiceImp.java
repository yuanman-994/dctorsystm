package com.dctor.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dctor.mapper.IndexMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImp implements IndexService {
    @Resource
    private IndexMapper indexMapper;

    @Override
    public int getOldMenNum(int docId) {
        return indexMapper.getOldMenNumByDocId(docId);
    }

    @Override
    public String getAdvisoryData(int docId) {
        List<Map> data = indexMapper.getAdvisoryData(1);

        System.out.println(data);
        //拿到的数据不包含咨询数为0的日期
        //exp:[{date=2020-06-26, num=5}, {date=2020-06-28, num=6}]

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date dNow = new Date();
        long oneDay = 1000 * 60 * 60 * 24;
        Date dStart = new Date(dNow.getTime() - oneDay * 6);
        String[] aWeek = new String[7];
        for (int i = 0; i <= 6; i++)
            aWeek[i] = ft.format(new Date(dStart.getTime() + oneDay * i));

        int k = 0;
        JSONArray ja = new JSONArray();
        JSONArray jb = new JSONArray();
        for (int i = 0; i <= 6; i++) {
            String date = aWeek[i];
            if (k < data.size()) {
                String tdate = (String) data.get(k).get("date");
                System.out.println(tdate);
                System.out.println(date);
                if (date.equals(tdate)) {
                    ja.add(date);
                    jb.add(data.get(k).get("num"));
                    k++;
                } else {
                    ja.add(date);
                    jb.add(0);
                }
            } else {
                ja.add(date);
                jb.add(0);
            }
        }
        JSONObject j = new JSONObject();
        j.put("num", jb);
        j.put("date", ja);
        System.out.println(j.toJSONString());
        return j.toJSONString();
    }
}
