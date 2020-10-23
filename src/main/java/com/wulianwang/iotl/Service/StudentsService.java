package com.wulianwang.iotl.Service;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Students;
import com.wulianwang.iotl.DataBase.StudentsDao;
import com.wulianwang.iotl.Interface.StudentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 19:42
 */
@Service
public class StudentsService implements StudentsInterface {
    @Autowired
    StudentsDao studentsDao;


    @Override
    public List<Students> getStudentsList(int start_page, int page_size) {
        return studentsDao.getStudentsList(start_page, page_size);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsDao.getAllStudents();
    }


    @Override
    public int changeStudentPWD(int s_number, String old_pwd, String new_pwd) {
        return studentsDao.changeStudentPWD(s_number, old_pwd, new_pwd);
    }


    @Override
    public List<Students> getStudent(int s_number) {
        return studentsDao.getStudent(s_number);
    }

    @Override
    public int uploadEquipmentCode(int s_number, String code) {
        return studentsDao.uploadEquipmentCode(s_number, code);
    }

    @Override
    public void uploadHeadPortrait(int s_number, String headPortrait) {
        studentsDao.uploadHeadPortrait(s_number, headPortrait);
    }

    @Override
    public int login(int s_number, String pwd) {
        return studentsDao.login(s_number, pwd);
    }

    @Override
    public int checkEquipmentCode(int s_number, String code) {
        return studentsDao.checkEquipmentCode(s_number, code);
    }

    @Override
    public int changeVacationDay(int s_number, int day) {
        return studentsDao.changeVacationDay(s_number,day);
    }

    @Override
    public void register(int s_number, String name) {
        studentsDao.register(s_number, name);
    }


}