package com.dctor.mapper;

import com.dctor.beans.Doctor;
import com.dctor.beans.Oldman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository

public interface OldmanMapper {
    @Select("select * from oldman where oldman.oldman_id = #{oldman_id}")
    Doctor findOldmanById(int oldman_id);
    @Select("select * from oldman where oldman_id in (select relation_oldman from relation where relation.relation_doctor = #{relation_doctor})")
    List<Oldman> findOldmanByDoctor(int relation_doctor);
}
