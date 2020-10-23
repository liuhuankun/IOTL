package com.wulianwang.iotl.DataBase;

import com.wulianwang.iotl.Bean.TimeTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 11:22
 */


@Mapper
@Repository
public interface TimeTableDao {
    @Select("call getTimeTableList(#{s_number})")
    List<TimeTable> getTimeTableList(int s_number);

    @Select("call getWeekNow()")
    int getWeekNow();

    @Select("call deleteTimeTable(#{s_number},#{name},#{day},#{time},#{week})")
    void deleteTimeTable(int s_number, String name, int day, int time, String week);

    @Select("call uploadTimeTable(#{s_number},#{name},#{day},#{time},#{week})")
    void uploadTimeTable(int s_number, String name, int day, int time, String week);

}
