package com.wulianwang.iotl.Service;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Statistics;
import com.wulianwang.iotl.DataBase.ClockDao;
import com.wulianwang.iotl.Interface.ClockInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 16:04
 */
@Service
public class ClockService implements ClockInterface {

    @Autowired
    ClockDao clockDao;

//    @Override
//    public List<Clock> getClockList(int c_s_number) {
//        return clockDao.getClockList(c_s_number);
//    }

    @Override
    public List<Clock> getSignInList(int s_number, String date) {
        return clockDao.getSignInList(s_number, date);
    }

    @Override
    public int SignIn(int s_number, String time) {
        return clockDao.SignIn(s_number, time);
    }

    @Override
    public List<Statistics> getSignInStatistics() {
        return clockDao.getSignInStatistics();
    }

    @Override
    public void unSignOut(int s_number, String time) {
        clockDao.unSignOut(s_number, time);
    }

    @Override
    public void unSignIn(int s_number, String time) {
        clockDao.unSignIn(s_number, time);
    }

    @Override
    public List<String> getSignInDayList(int s_number) {
        return clockDao.getSignInDayList(s_number);
    }


}