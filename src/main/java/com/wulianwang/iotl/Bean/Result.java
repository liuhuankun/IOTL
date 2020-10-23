package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 11:11
 */
public class Result {
    private int status;
    private String msg;
    private Object value;

    public Result() {
        this.status=100;
        this.msg="wrong";
        this.value=null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}