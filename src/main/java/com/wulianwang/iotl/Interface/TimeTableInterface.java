package com.wulianwang.iotl.Interface;

import com.wulianwang.iotl.Bean.TimeTable;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 10:47
 */
public interface TimeTableInterface {
    List<TimeTable> getTimeTableList(int s_number);

    void deleteTimeTable(int s_number, String name, int day, int time, String week);

    void uploadTimeTable(int s_number,String name,int day,int time,String week);

    int getWeekNow();
}
