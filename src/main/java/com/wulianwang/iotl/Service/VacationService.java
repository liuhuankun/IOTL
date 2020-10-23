package com.wulianwang.iotl.Service;

import com.wulianwang.iotl.Bean.Vacation;
import com.wulianwang.iotl.DataBase.VacationDao;
import com.wulianwang.iotl.Interface.VacationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:54
 */
@Service
public class VacationService implements VacationInterface {
    @Autowired
    VacationDao vacationDao;
    @Override
    public List<Vacation> getVacationList() {
        return vacationDao.getVacationList();
    }
}