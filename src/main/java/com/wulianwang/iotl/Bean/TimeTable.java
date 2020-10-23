package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 10:08
 */
public class TimeTable {
    private int c_s_number;//学生学号
    private String course_name;//课程名
    private int course_day;//课程在星期几？(1~7)
    private int course_time;//课程时间(1,2,3,4,5,6)
    private String course_week;//课程周数(例1-2-3-4)

    public TimeTable(int c_s_number, String course_name, int course_day, int course_time, String course_week) {
        this.c_s_number = c_s_number;
        this.course_name = course_name;
        this.course_day = course_day;
        this.course_time = course_time;
        this.course_week = course_week;
    }

    public TimeTable() {
    }

    public int getC_s_number() {
        return c_s_number;
    }

    public void setC_s_number(int c_s_number) {
        this.c_s_number = c_s_number;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_day() {
        return course_day;
    }

    public void setCourse_day(int course_day) {
        this.course_day = course_day;
    }

    public int getCourse_time() {
        return course_time;
    }

    public void setCourse_time(int course_time) {
        this.course_time = course_time;
    }

    public String getCourse_week() {
        return course_week;
    }

    public void setCourse_week(String course_week) {
        this.course_week = course_week;
    }
}