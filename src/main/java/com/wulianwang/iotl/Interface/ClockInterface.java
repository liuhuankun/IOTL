package com.wulianwang.iotl.Interface;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Statistics;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 15:19
 */
public interface ClockInterface {
//    List<Clock> getClockList(int c_s_number);
    List<Clock> getSignInList(int s_number, String date);
    int SignIn(int s_number,String time);
    List<Statistics> getSignInStatistics();
    void unSignOut(int s_number,String time);
    void unSignIn(int s_number,String time);
    List<String> getSignInDayList(int s_number);

}
