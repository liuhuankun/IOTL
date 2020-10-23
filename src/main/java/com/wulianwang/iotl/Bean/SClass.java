package com.wulianwang.iotl.Bean;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-10-09 15:58
 */
public class SClass {

    private int weeks;//课程周数
    private int v_status;//休假状态
    private String[][] s_time;//课程时间

    public SClass() {
        s_time = new String[7][6];
        weeks = 1;
        v_status = 0;
    }

    public int getV_status() {
        return v_status;
    }

    public void setV_status(int v_status) {
        this.v_status = v_status;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public String[][] getS_time() {
        return s_time;
    }

    //    public void setS_time(List<TimeTable> timeTables,int v_day) {
//        for(int i = 0;i<7;i++){
//            for(int x = 0;x<timeTables.size();x++){
//                if((v_day == 0 && i== 6) || (v_day == 1 && i== 5)){
//                    for(int j = 0;j<6;j++){
//                            this.s_time[i][j]="休假";
//                    }
//                }
//                if(timeTables.get(x).getCourse_day() == i+1){
//                    for(int j = 0;j<6;j++){
//                        if(timeTables.get(x).getCourse_time() == j+1){
//                            this.s_time[i][j]=timeTables.get(x).getCourse_name();
//                        }
//                    }
//                }
//            }
//
//        }
//    }
    public void setS_time(List<TimeTable> timeTables) {
        for (int i = 0; i < 7; i++) {
            for (int x = 0; x < timeTables.size(); x++) {
                if (timeTables.get(x).getCourse_day() == i + 1) {
                    for (int j = 0; j < 6; j++) {
                        if (timeTables.get(x).getCourse_time() == j + 1) {
                            this.s_time[i][j] = timeTables.get(x).getCourse_name();
                        }
                    }
                }
            }

        }
    }
}