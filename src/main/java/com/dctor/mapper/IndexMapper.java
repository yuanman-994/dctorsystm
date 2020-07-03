package com.dctor.mapper;

import com.alibaba.druid.sql.visitor.functions.If;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface IndexMapper{
    @Select("SELECT COUNT(*) FROM relation WHERE relation_doctor = #{docId}")
    int getOldMenNumByDocId(int docId);

    @Select("SELECT estimate_date as date , count(estimate_date) as num " +
            "FROM estimate " +
            "WHERE estimate_doctor = 1 AND estimate_date > DATE_ADD(CURRENT_DATE(),INTERVAL -1 WEEK) " +
            "GROUP BY estimate_date " +
            "ORDER BY estimate_date ASC")
    List<Map> getAdvisoryData(int docId);//查询过去七天每天的资询数
    //exp:[{date=2020-06-26, num=5}, {date=2020-06-28, num=6}]
}
