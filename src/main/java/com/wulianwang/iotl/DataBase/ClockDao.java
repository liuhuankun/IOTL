package com.wulianwang.iotl.DataBase;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Statistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 15:16
 */


@Mapper
@Repository
public interface ClockDao {
//    @Select("call getClockList(#{c_s_number})")
//    List<Clock> getClockList(@Param("c_s_number") int c_s_number);

    @Select("call getSignInList(#{s_number},#{date})")
    List<Clock> getSignInList(@Param("s_number") int s_number, @Param("date") String date);

    @Select("call SignIn(#{s_number},#{time})")
    int SignIn(@Param("s_number") int s_number, @Param("time") String time);

    @Select("call getSignInStatistics()")
    List<Statistics> getSignInStatistics();

    @Select("call getSignInDayList(#{s_number})")
    List<String> getSignInDayList(@Param("s_number") int s_number);

    @Insert("call unSignOut(#{s_number},#{time})")
    void unSignOut(@Param("s_number") int s_number, @Param("time") String time);

    @Insert("call unSignIn(#{s_number},#{time})")
    void unSignIn(@Param("s_number") int s_number, @Param("time") String time);


}
