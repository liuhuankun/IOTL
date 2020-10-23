package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 19:54
 */
public class Vacation {
    private int v_s_number;//学生学号
    private String v_time_begin;//请假起始时间
    private String v_time_end;//请假结束时间
    private String v_reason;//请假原因
    private int v_state;//请假状态(1：批准0：未批准-1：驳回)

    public Vacation(int v_s_number, String v_time_begin, String v_time_end, String v_reason, int v_state) {
        this.v_s_number = v_s_number;
        this.v_time_begin = v_time_begin;
        this.v_time_end = v_time_end;
        this.v_reason = v_reason;
        this.v_state = v_state;
    }

    public Vacation() {
    }

    public int getV_s_number() {
        return v_s_number;
    }

    public void setV_s_number(int v_s_number) {
        this.v_s_number = v_s_number;
    }

    public String getV_time_begin() {
        return v_time_begin;
    }

    public void setV_time_begin(String v_time_begin) {
        this.v_time_begin = v_time_begin;
    }

    public String getV_time_end() {
        return v_time_end;
    }

    public void setV_time_end(String v_time_end) {
        this.v_time_end = v_time_end;
    }

    public String getV_reason() {
        return v_reason;
    }

    public void setV_reason(String v_reason) {
        this.v_reason = v_reason;
    }

    public int getV_state() {
        return v_state;
    }

    public void setV_state(int v_state) {
        this.v_state = v_state;
    }
}