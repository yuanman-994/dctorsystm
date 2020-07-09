package com.dctor.mapper;

import com.alibaba.druid.sql.visitor.functions.If;
import com.dctor.beans.Consult;
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

    @Select("SELECT date , COUNT(date) as num\n" +
            "FROM (\n" +
            "\t\tSELECT date_format(ask_datetime,'%Y-%m-%d') as date\n" +
            "\t\tFROM consult\n" +
            "\t\tWHERE ask_doctor = #{ask_doctor} AND ask_datetime > DATE_ADD(CURRENT_DATE(),INTERVAL -6 DAY)\n" +
            ") as tmp\n" +
            "GROUP BY date\n" +
            "ORDER BY date ASC")
    List<Map> getAdvisoryData(int ask_doctor);//查询过去七天每天的资询数
    //exp:[{date=2020-06-26, num=5}, {date=2020-06-28, num=6}]
}
