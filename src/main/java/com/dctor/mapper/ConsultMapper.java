package com.dctor.mapper;


import com.dctor.beans.Consult;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ConsultMapper {

    @Select("SELECT * FROM consult ")
    public List<Consult> findAllConsult();

    @Select("SELECT * FROM consult WHERE ask_id = #{ask_id}")
    public Consult findConsultById(Integer ask_id);

    @Insert("INSERT INTO consult (ask_test,ask_state,ask_doctor,ask_oldman,ask_answer,ask_question,ask_datetime) " +
            "VALUES (#{ask_test},#{ask_state},#{ask_doctor},#{ask_oldman},#{ask_answer},#{ask_question},#{ask_datetime})")
    @Options(useGeneratedKeys=true, keyProperty="ask_id", keyColumn="ask_id")
    public int addConsult(Consult consult);

    @Update("UPDATE  consult SET  "+
            "ask_state = #{ask_state}, "+
            "ask_answer = #{ask_answer} "+
            "WHERE ask_id = #{ask_id} "
    )
    public int updateConsult(Integer ask_id,String ask_answer,String ask_state);

    @SelectProvider(type = selectProvider.class, method = "search")
    @Results({
            @Result(id=true,property = "ask_id",column = "ask_id"),
            @Result(property = "ask_test",column = "ask_test"),
            @Result(property = "ask_state",column = "ask_state"),
            @Result(property = "ask_doctor",column = "ask_doctor"),
            @Result(property = "ask_oldman",column = "ask_oldman"),
            @Result(property = "ask_answer",column = "ask_answer"),
            @Result(property = "ask_question",column = "ask_question"),
            @Result(property = "ask_datetime",column = "ask_datetime"),
    })
    public List<Consult> searchConsults(@Param(value = "ask_oldman") String ask_oldman,@Param(value = "ask_datetime") String ask_datetime,@Param(value = "ask_state") String ask_state);


    class selectProvider {
        /* 条件组合查询 */
        public String search(Map<String,Object> param) {
            String ask_oldman = param.get("ask_oldman").toString();
            String select_date = param.get("ask_datetime").toString();
            String select_status = param.get("ask_state").toString();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM consult c WHERE ");
            if(ask_oldman!=null){
                sb.append("c.ask_oldman like CONCAT('%',#{ask_oldman},'%') AND ");
            }
            if(!select_date.equals("datenone")){
                Date date=new Date();
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                if(select_date.equals("week")) {
                    c.add(Calendar.DAY_OF_MONTH,-7);
                    Date date1 = c.getTime();
                    sb.append("c.ask_datetime <= "+"\""+simpleDate.format(date)+"\"");
                    sb.append(" AND c.ask_datetime >= "+"\""+simpleDate.format(date1)+"\"");
                    sb.append(" AND ");
                }
                else if(select_date.equals("month")) {
                    c.add(Calendar.MONTH,-1);
                    Date date2 = c.getTime();
                    sb.append("c.ask_datetime <= "+"\""+simpleDate.format(date)+"\"");
                    sb.append(" AND c.ask_datetime >= "+"\""+simpleDate.format(date2)+"\"");
                    sb.append(" AND ");
                }
            } else {
                sb.append("1=1 AND ");
            }
            if(!select_status.equals("statusnone")){
                if(select_status.equals("answered")){
                    sb.append("c.ask_state = '已回复'");
                }
                else if (select_status.equals("unanswer")){
                    sb.append("c.ask_state = '未回复'");
                }
            } else {
                sb.append("1=1");
            }

            return sb.toString();
        }
    }
}
