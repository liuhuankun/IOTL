package com.wulianwang.iotl.Controller;

//import com.sun.javaws.Main;
import com.wulianwang.iotl.Bean.*;
import com.wulianwang.iotl.Interface.ClockInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationEvent;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lhk
 * @description
 * @create 2020-09-12 15:16
 */

@Api(value = "时间信息相关接口",description = "时间信息相关接口")
@Slf4j
@RestController
public class ClockController {
    @Autowired
    ClockInterface clockInterface;


//    @RequestMapping(value = "/getClockList", method = RequestMethod.POST)
//    public Result getClockList(@Param("c_s_number") int c_s_number) {
//        Result result = new Result();
//        try {
//            List<Clock> clock = new ArrayList<>(clockInterface.getClockList(c_s_number));
//            if (clock.size() > 0) {
//                result.setMsg("获取成功");
//                result.setStatus(100);
//                result.setValue(clock);
//            } else {
//                result.setMsg("Not Found");
//                result.setStatus(200);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setMsg("获取失败");
//            result.setStatus(300);
//        }
//
//        return result;
//    }

    @ApiOperation(
            value = "获取学生签到信息列表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：出现异常；\n\n"
                    + "2.返回值value数组：\n\n" +
                    "偶数为日期" +
                    "单数为前面日期对应的记录" +
                    "学生id：\" c_s_number \"\n\n" +
                    "签到时间：\" c_time \"\n\n" +
                    "签到状态：\" c_type \"\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "start_page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page_size", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    }
    )
    @RequestMapping(value = "/getSignInList", method = RequestMethod.POST)
    public Result getSignInList(@Param("s_number") int s_number, @Param("start_page") int start_page, @Param("page_size") int page_size) {
        String logText = "请求获得学生签到信息列表学号：" + s_number + "，页码为" + start_page + "获取数据条目数" + page_size;
        Result result = new Result();
        try {
            start_page = (start_page - 1) * page_size;
            List<String> dates = new ArrayList<>(clockInterface.getSignInDayList(s_number));
            List<Map<String,List<Clock>>> res = new ArrayList<>();
            for(int i = 0;i<page_size && dates.size()>start_page+i;i++){
                List<Clock> clocks = new ArrayList<>(clockInterface.getSignInList(s_number,dates.get(start_page+i) ));
                Map<String,List<Clock>> map = new HashMap<String,List<Clock>>();
                map.put(dates.get(start_page+i),clocks);
                res.add(map);
            }
            if (res.size() > 0) {
                result.setMsg("success");
                result.setStatus(100);
                result.setValue(res);
                log.info(logText + "获取成功");
            } else {
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText + "无学生签到信息或数据不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error!");
            result.setStatus(300);
            log.error(logText + "操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "获取签到统计信息",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：出现异常；\n\n"
                    + "2.返回值value数组：\n\n" +
                    "签到：\" qd \"\n\n" +
                    "签退：\" qt \"\n\n" +
                    "未签到：\" unqd \"\n\n" +
                    "未签退：\" unqt \"\n\n"
    )

    @RequestMapping(value = "/getSignInStatistics", method = RequestMethod.POST)
    public Result getSignInStatistics() {
        String logText = "请求获取签到统计信息";
        Result result = new Result();
        try {
            List<Statistics> statistics = new ArrayList<>(clockInterface.getSignInStatistics());
            if (statistics.size() > 0) {

                result.setMsg("success");
                result.setStatus(100);
                result.setValue(statistics);
                log.info(logText + "获取成功");
            } else {
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText + "无签到统计信息或信息不足");

            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + "操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "签到",
            notes = "1.返回值状态（status）\n\n" +
                    "97：当前不是签到时间；\n\n" +
                    "98：有课或无需签到；\n\n" +
                    "99：已签到或签退；\n\n" +
                    "100：签到成功；\n\n" +
                    "101：签退成功；\n\n" +
                    "300：出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "int", paramType = "int"),
    })
    @RequestMapping(value = "/SignIn", method = RequestMethod.POST)
    public Result SignIn(@Param("s_number") int s_number) {
        String logText = "学号为"+s_number+"的用户请求签到或签退，";
        Result result = new Result();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //签到状态(0：签到成功 1：签退成功 -1：已签到\退 -2：有课或无需签到 -3:当前不是签到时间)
        try {
            int statusNum = clockInterface.SignIn(s_number, formatter.format(new Date()));

            System.out.println(statusNum);
            if (statusNum == -3) {
                result.setMsg("当前不是签到或签退时间");
                result.setStatus(97);
                log.info(logText + "当前不是签到或签退时间");
            } else if (statusNum == -2) {
                result.setMsg("有课或无需签到");
                result.setStatus(98);
                log.info(logText + "有课或无需签到");

            } else if (statusNum == -1) {
                result.setMsg("已签到或签退");
                result.setStatus(99);
                log.info(logText + "已签到或签退");

            } else if (statusNum == 0) {
                result.setMsg("签到成功");
                result.setStatus(100);
                log.info(logText + "签到成功");

            } else if (statusNum == 1) {
                result.setMsg("签退成功");
                result.setStatus(101);
                log.info(logText + "签退成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("操作异常");
            result.setStatus(300);
            log.error(logText+"操作异常");
        }
        return result;
    }


}


