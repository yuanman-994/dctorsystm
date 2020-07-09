package com.dctor.mapper;


import com.dctor.beans.Estimate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EstimateMapper {

    @Select("SELECT * FROM estimate ")
    public List<Estimate> findAllEstimate();

    @Select("SELECT * FROM Estimate WHERE estimate_id = #{estimate_id}")
    public Estimate findEstimateById(int estimate_id);

    @Select("select * from Estimate where estimate_id = #{estimate_id})")
    public Estimate findEstimateByDoctor(int estimate_doctor);

    @Select("select * from Estimate where estimate_id = #{estimate_id})")
    public Estimate findEstimateByOldman(int estimate_oldman);

    @Insert("INSERT INTO estimate (estimate_healthy,estimate_content,estimate_datetime) " +
            "VALUES (#{estimate_healthy},#{estimate_content},#{estimate_suggest},#{estimate_datetime})")
    @Options(useGeneratedKeys=true, keyProperty="estimate_id", keyColumn="estimate_id")
    public int addEstimate(Estimate estimate);

    @Update("UPDATE  estimate SET  "+
            "estimate_content = #{estimate_content}, "+
            "estimate_suggest = #{estimate_suggest}, "+
            "estimate_datetime = #{estimate_datetime}, "+
            "WHERE estimate_id = #{estimate_id} "
    )
    public int updateEstimate(Integer estimate_id, String estimate_content, String estimate_suggest, String estimate_datetime);}
