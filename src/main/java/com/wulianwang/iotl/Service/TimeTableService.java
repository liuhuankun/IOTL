package com.wulianwang.iotl.Service;

import com.wulianwang.iotl.Bean.TimeTable;
import com.wulianwang.iotl.DataBase.TimeTableDao;
import com.wulianwang.iotl.Interface.TimeTableInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 14:13
 */
@Service
public class TimeTableService implements TimeTableInterface {

    @Autowired
    TimeTableDao timeTableDao;


    @Override
    public List<TimeTable> getTimeTableList(int s_number) {
        return timeTableDao.getTimeTableList(s_number);

    }

    @Override
    public void deleteTimeTable(int s_number, String name, int day, int time, String week) {
        timeTableDao.deleteTimeTable(s_number, name, day, time, week);
    }

    @Override
    public void uploadTimeTable(int s_number, String name, int day, int time, String week) {
        timeTableDao.uploadTimeTable(s_number, name, day, time, week);
    }

    @Override
    public int getWeekNow() {
        return timeTableDao.getWeekNow();
    }


}