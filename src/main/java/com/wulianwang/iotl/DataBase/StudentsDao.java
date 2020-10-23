package com.wulianwang.iotl.DataBase;

import com.wulianwang.iotl.Bean.Students;
import com.wulianwang.iotl.Bean.Clock;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 19:43
 */

@Mapper
@Repository
public interface StudentsDao {
    @Select("call getStudentsList(#{start_page},#{page_size})")
    List<Students> getStudentsList(@Param("start_page") int start_page, @Param("page_size") int page_size);

    @Select("call getAllStudents()")
    List<Students> getAllStudents();

    @Select("call getStudent(#{s_number})")
    List<Students> getStudent(@Param("s_number") int s_number);

//    @Select("call changeEquipmentCode(#{s_number},#{equipment_code})")
//    void changeEquipmentCode(@Param("s_number") int s_number, @Param("equipment_code") String equipment_code);

    @Select("call changeStudentPWD(#{s_number},#{old_pwd},#{new_pwd})")
    int changeStudentPWD(@Param("s_number") int s_number, @Param("old_pwd") String old_pwd, @Param("new_pwd") String new_pwd);

    @Select("call uploadEquipmentCode(#{s_number},#{code})")
    int uploadEquipmentCode(@Param("s_number") int s_number, @Param("code") String code);

    @Select("call uploadHeadPortrait(#{s_number},#{headPortrait})")
    void uploadHeadPortrait(@Param("s_number") int s_number, @Param("headPortrait") String headPortrait);

    @Select("call login(#{s_number},#{pwd})")
    int login(@Param("s_number") int s_number, @Param("pwd") String pwd);


    @Select("call checkEquipmentCode(#{s_number},#{code})")
    int checkEquipmentCode(@Param("s_number") int s_number, @Param("code") String code);

    @Select("call changeVacationDay(#{s_number},#{day})")
    int changeVacationDay(@Param("s_number") int s_number,@Param("day") int day);

    @Insert("call register(#{s_number},#{name})")
    void register(@Param("s_number") int s_number, @Param("name") String name);

}
