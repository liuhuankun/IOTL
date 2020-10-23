package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 19:37
 */
public class Students {
    private int s_number;//学生学号
    private String s_password;//密码
    private String s_name;//学生姓名
    private String s_headPortrait;//学生头像
    private int s_v_day;//学生休假时间(1:周六0：周日(默认0))
    private double s_grade=100;//学生学期积分

    public Students() {
    }

    public Students(int s_number, String s_password, String s_name, String s_headPortrait, int s_v_day, double s_grade) {
        this.s_number = s_number;
        this.s_password = s_password;
        this.s_name = s_name;
        this.s_headPortrait = s_headPortrait;
        this.s_v_day = s_v_day;
        this.s_grade = s_grade;
    }

    public double getS_grade() {
        return s_grade;
    }

    public void setS_grade(double s_grade) {
        this.s_grade = s_grade;
    }

    public int getS_number() {
        return s_number;
    }

    public void setS_number(int s_number) {
        this.s_number = s_number;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_headPortrait() {
        return s_headPortrait;
    }

    public void setS_headPortrait(String s_headPortrait) {
        this.s_headPortrait = s_headPortrait;
    }

    public int getS_v_day() {
        return s_v_day;
    }

    public void setS_v_day(int s_v_day) {
        this.s_v_day = s_v_day;
    }
}