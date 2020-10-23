package com.wulianwang.iotl.Interface;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Students;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 19:24
 */
public interface StudentsInterface {
    List<Students> getStudentsList(int start_page,int page_size);
    List<Students> getAllStudents();
    List<Students> getStudent(int s_number);
//    void changeEquipmentCode(int s_number,String equipment_code);
    int changeStudentPWD(int s_number,String old_pwd,String new_pwd);
    int uploadEquipmentCode(int s_number,String code);
    void uploadHeadPortrait(int s_number,String headPortrait);
    int login(int s_number,String pwd);
    int checkEquipmentCode(int s_number,String code);
    int changeVacationDay(int s_number,int day);
    void register(int s_number,String name);

}
