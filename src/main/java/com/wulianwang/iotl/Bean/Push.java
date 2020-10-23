package com.wulianwang.iotl.Bean;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 19:51
 */
public class Push {
    private String p_time;//推送时间
    private String p_describe;//推送概述
    private String p_title;//推送标题
    private String p_content;//推送正文

    public Push() {
    }

    public Push(String p_time, String p_describe, String p_title, String p_content) {
        this.p_time = p_time;
        this.p_describe = p_describe;
        this.p_title = p_title;
        this.p_content = p_content;
    }

    public String getP_time() {
        return p_time;
    }

    public void setP_time(String p_time) {
        this.p_time = p_time;
    }

    public String getP_describe() {
        return p_describe;
    }

    public void setP_describe(String p_describe) {
        this.p_describe = p_describe;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }
}