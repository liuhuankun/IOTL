package com.wulianwang.iotl.Controller;

import com.wulianwang.iotl.Bean.Push;
import com.wulianwang.iotl.Bean.Result;
import com.wulianwang.iotl.Interface.PushInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:11
 */
@Api(value = "推送信息相关接口",description = "推送信息相关接口")
@Slf4j
@RestController
public class PushController {
    @Autowired
    PushInterface pushInterface;


    @RequestMapping
    public Result getPushList() {
        Result result = new Result();
        try {
            ArrayList<Push> push = new ArrayList<>(pushInterface.getPushList());
            if (push.size() == 0) {
                result.setMsg("Not Found");
                result.setStatus(200);
            } else {
                result.setMsg("Success");
                result.setStatus(100);
                result.setValue(push);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
        }
        return result;
    }
}