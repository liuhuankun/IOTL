package com.wulianwang.iotl.Controller;

import com.wulianwang.iotl.Bean.Result;
import com.wulianwang.iotl.Bean.Vacation;
import com.wulianwang.iotl.Interface.VacationInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:47
 */
@Api(value = "假期信息相关接口",description = "假期信息相关接口")
@RestController
public class VacationController {
    @Autowired
    VacationInterface vacationInterface;
    @RequestMapping(value = "/getVacationList",method = RequestMethod.POST)
    public Result getVacationList(){
        Result result = new Result();
        try {
            List<Vacation> vacation = new ArrayList<>(vacationInterface.getVacationList());
            if(vacation.size()>0){
                result.setMsg("获取成功");
                result.setStatus(100);
                result.setValue(vacation);
            }else{
                result.setMsg("Not Found");
                result.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("获取失败");
            result.setStatus(300);
        }
        return result;
    }

}