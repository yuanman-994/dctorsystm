package com.dctor.mapper;

import org.apache.ibatis.annotations.*;
import com.dctor.beans.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository

public interface DoctorMapper {
    @Select("select * from doctor where doctor.doctor_id = #{doctor_id}")
    Doctor findDoctorById(int doctor_id);
    @Select("select * from doctor where doctor_id in (select relation_doctor from relation where relation.relation_oldman = #{relation_oldman})")
    List<Doctor> findDoctorByOldman(int relation_oldman);
}
