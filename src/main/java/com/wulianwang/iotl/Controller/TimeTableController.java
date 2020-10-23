package com.wulianwang.iotl.Controller;

import com.wulianwang.iotl.Bean.*;
import com.wulianwang.iotl.Interface.StudentsInterface;
import com.wulianwang.iotl.Interface.TimeTableInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 10:38
 */
@Api(value = "时间表信息相关接口", description = "时间表信息相关接口")
@Slf4j
@RestController
public class TimeTableController {
    @Autowired
    StudentsInterface studentsInterface;
    @Autowired
    TimeTableInterface timeTableInterface;

    @ApiOperation(
            value = "获获取学生课表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：出现异常；\n\n" +
                    "返回值是一个含有weeks,s_time两个属性的对象的数组" +
                    "数组的第一个值即为第一周的课表，weeks为1" +
                    "s_time是一个7*6的二维数组，横坐标对应课节数,纵坐标对应周数" +
                    "即data[0]为第一周的课表" +
                    "属性weeks值为1" +
                    "s_time[0][0]~s_time[0][5]即为周一一天的课" +
                    "v_status是休假时间 1为周六 0为周日"

    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
    }
    )

    @RequestMapping(value = "/getTimeTableList", method = RequestMethod.POST)
    public Result getTimeTableList(@Param("s_number") int s_number) {
        String logText = "请求获取学号为：" + s_number + "的课表，";
        Result result = new Result();
        try {
            List<TimeTable> timeTable = new ArrayList<>(timeTableInterface.getTimeTableList(s_number));
            List<TimeTable> t = new ArrayList<>();
            List<SClass> s_classes = new ArrayList<>();
            if (timeTable.size() > 0) {
                for (int i = 1; i < 25; i++) {
                    SClass s_class = new SClass();
                    s_class.setWeeks(i);
                    s_class.setV_status(studentsInterface.getStudent(s_number).get(0).getS_v_day());
                    for (int x = 0; x < timeTable.size(); x++) {
                        if (timeTable.get(x).getCourse_week().indexOf("," + i + ",") != -1) {
                            t.add(timeTable.get(x));
                        }
                    }
                    s_class.setS_time(t);
                    t.clear();
                    s_classes.add(s_class);
                }
                result.setMsg("Success");
                result.setStatus(100);
                result.setValue(s_classes);
                log.info(logText + "获取成功");
            } else {
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText + ",无数据或数据不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + "操作出现异常");
        }

        return result;
    }

//    @ApiOperation(
//            value = "获获取学生课表接口",
//            notes = "1.返回值状态（status）\n\n" +
//                    "100：数据获取成功；\n\n" +
//                    "200：未找到数据；\n\n" +
//                    "300：出现异常；\n\n" +
//                    "返回值是一个含有weeks,s_time两个属性的对象的数组" +
//                    "数组的第一个值即为第一周的课表，weeks为1" +
//                    "s_time是一个7*6的二维数组，横坐标对应课节数,纵坐标对应周数" +
//                    "即data[0]为第一周的课表" +
//                    "属性weeks值为1" +
//                    "s_time[0][0]~s_time[0][5]即为周一一天的课"
//    )
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
//    }
//    )
//
//    @RequestMapping(value = "/getTimeTableList", method = RequestMethod.POST)
//    public Result getTimeTableList(@Param("s_number") int s_number) {
//        String logText = "请求获取学号为：" + s_number + "的课表，";
//        Result result = new Result();
//        try {
//            List<TimeTable> timeTable = new ArrayList<>(timeTableInterface.getTimeTableList(s_number));
//            List<TimeTable> t = new ArrayList<>();
//            List<SClass> s_classes = new ArrayList<>();
//            if (timeTable.size() > 0) {
//                for (int i = 1; i < 25; i++) {
//                    SClass s_class = new SClass();
//                    s_class.setWeeks(i);
//                    for (int x = 0; x < timeTable.size(); x++) {
//                        if (timeTable.get(x).getCourse_week().indexOf("," + i + ",") != -1) {
//                            t.add(timeTable.get(x));
//                        }
//                    }
//                    s_class.setS_time(t, studentsInterface.getStudent(s_number).get(0).getS_v_day());
//                    t.clear();
//                    s_classes.add(s_class);
//                }
//                result.setMsg("Success");
//                result.setStatus(100);
//                result.setValue(s_classes);
//                log.info(logText + "获取成功");
//            } else {
//                result.setMsg("Not Found");
//                result.setStatus(200);
//                log.info(logText + ",无数据或数据不足");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setMsg("Error");
//            result.setStatus(300);
//            log.error(logText + "操作出现异常");
//        }
//
//        return result;
//    }


    @ApiOperation(
            value = "删除课表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "300：出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "name", value = "课程名", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "day", value = "星期几（1到7）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "time", value = "课程时间(1,2,3,4,5,6)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "week", value = "课程周数(例,1,2,3,4,)", required = true, dataType = "String", paramType = "String"),

    }
    )
    @RequestMapping(value = "/deleteTimeTable", method = RequestMethod.POST)
    public Result deleteTimeTable(@Param("s_number") int s_number, @Param("name") String name, @Param("day") int day, @Param("time") int time, @Param("week") String week) {
        String logText = "学号为：" + s_number + "的用户请求删除课程，课程周数为：" + week + ",星期为" + day + "，课程时间为" + time + ",课程名为" + name;
        Result result = new Result();
        try {
            timeTableInterface.deleteTimeTable(s_number, name, day, time, week);
            result.setMsg("Success");
            result.setStatus(100);
            log.info(logText + ",删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "获取当前周数",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "300：出现异常；\n\n" +
                    "返回型为整型数字"
    )
    @RequestMapping(value = "/getWeekNow", method = RequestMethod.POST)
    public Result getWeekNow() {
        Result result = new Result();
        String logText = "请求获取当前周数，";
        try {
            int week = timeTableInterface.getWeekNow();
            result.setMsg("Success");
            result.setStatus(100);
            result.setValue(week);
            log.info(logText + "当前是" + week);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "上传课表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "300：出现异常；\n\n"

    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "name", value = "课程名", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "day", value = "星期几（1到7）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "time", value = "课程时间(1,2,3,4,5,6)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "week", value = "课程周数(例1-2-3-4)", required = true, dataType = "String", paramType = "String"),

    }
    )
    @RequestMapping(value = "/uploadTimeTable", method = RequestMethod.POST)
    public Result uploadTimeTable(@Param("s_number") int s_number, @Param("name") String name, @Param("day") int day, @Param("time") int time, @Param("week") String week) {
        String logText = "学号为：" + s_number + "的用户请求上传课程，课程周数为：" + week + ",星期为" + day + "，课程时间为" + time + ",课程名为" + name;
        Result result = new Result();
        try {
            timeTableInterface.uploadTimeTable(s_number, name, day, time, week);
            result.setMsg("Success");
            result.setStatus(100);
            log.info(logText + ",上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }

}