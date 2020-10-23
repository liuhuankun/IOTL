package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 15:13
 */
public class Clock {
    private int c_s_number;//学生id
    private String c_time;//签到时间
    private int c_type;//签到状态(0：签到1：签退-1：签到未签-2：签退未签)

    public Clock() {
    }

    public Clock(int c_s_number, String c_time, int c_type) {
        this.c_s_number = c_s_number;
        this.c_time = c_time;
        this.c_type = c_type;
    }

    public int getC_type() {
        return c_type;
    }

    public void setC_type(int c_type) {
        this.c_type = c_type;
    }

    public int getC_s_number() {
        return c_s_number;
    }

    public void setC_s_number(int c_s_number) {
        this.c_s_number = c_s_number;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }
}