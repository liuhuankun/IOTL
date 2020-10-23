package com.wulianwang.iotl.Controller;

import com.wulianwang.iotl.Bean.Clock;
import com.wulianwang.iotl.Bean.Result;
import com.wulianwang.iotl.Bean.Students;
import com.wulianwang.iotl.Interface.StudentsInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.LogRecord;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 19:27
 */

@Api(value = "学生信息相关接口", description = "学生信息相关接口")
@Slf4j
@RestController
public class StudentsController {
    @Autowired
    StudentsInterface studentsInterface;
    @Value("${upload.image.location}")
    String uploadLocation;

    @ApiOperation(
            value = "获取学生列表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：出现异常；\n\n"
                    + "2.返回值value数组：\n\n" +
                    "学生学号：\" s_number \"\n\n" +
                    "密码：\" s_password \"\n\n" +
                    "学生姓名：\" s_name \"\n\n" +
                    "学生头像：\" s_headPortrait \"\n\n" +
                    "学生休假时间(1:周六0：周日(默认0))：\" s_v_day \"\n\n" +
                    "学生学期积分：\" s_grade \"\n\n"

    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start_page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page_size", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    }
    )
    @RequestMapping(value = "/getStudentsList", method = RequestMethod.POST)
    public Result getStudentsList(@Param("start_page") int start_page, @Param("page_size") int page_size) {
        String logText = "请求获取获取学生列表，页码为" + start_page + ",获取数据条目数" + page_size;
        Result result = new Result();
        try {
            start_page = (start_page - 1) * page_size;
            List<Students> students = new ArrayList<>(studentsInterface.getStudentsList(start_page, page_size));
            if (students.size() > 0) {
                result.setMsg("Success");
                result.setStatus(100);
                result.setValue(students);
                log.info(logText + "，获取成功");
            } else {
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText + ",无数据或数据不足");
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
            value = "获取单个学生信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：出现异常；\n\n"
                    + "2.返回值value数组：\n\n" +
                    "学生学号：\" s_number \"\n\n" +
                    "密码：\" s_password \"\n\n" +
                    "学生姓名：\" s_name \"\n\n" +
                    "学生头像：\" s_headPortrait \"\n\n" +
                    "学生休假时间(1:周六0：周日(默认0))：\" s_v_day \"\n\n" +
                    "学生学期积分：\" s_grade \"\n\n"

    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
    }
    )
    @RequestMapping(value = "/getStudent", method = RequestMethod.POST)
    public Result getStudent(@Param("s_number") int s_number) {
        String logText = "请求获取学生学号为：" + s_number + "的信息";
        Result result = new Result();
        try {
            List<Students> students = new ArrayList<>(studentsInterface.getStudent(s_number));
            if (students.size() > 0) {
                result.setMsg("Success");
                result.setStatus(100);
                result.setValue(students);

                log.info(logText + ",获取成功");
            } else {
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText + "，无数据或数据不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + "操作出现异常");
        }
        return result;
    }


//    @RequestMapping(value = "/changeEquipmentCode", method = RequestMethod.POST)
//    public Result changeEquipmentCode(@Param("s_number") int s_number, @Param("equipment_code") String equipment_code) {
//        Result result = new Result();
//        try {
//            studentsInterface.changeEquipmentCode(s_number, equipment_code);
//            result.setMsg("获取成功");
//            result.setStatus(100);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setMsg("获取失败");
//            result.setStatus(300);
//        }
//        return result;
//    }


    @ApiOperation(
            value = "校验设备码接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：检验成功；\n\n" +
                    "200：检验失败；\n\n" +
                    "300：检验异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "code", value = "设备码", required = true, dataType = "String", paramType = "String"),

    }
    )
    @RequestMapping(value = "/checkEquipmentCode", method = RequestMethod.POST)
    public Result checkEquipmentCode(@Param("s_number") int s_number, @Param("code") String code) {
        String logText = "检验学号为：" + s_number + "的设备码";
        Result result = new Result();
        try {
            int checkEquipmentCode = studentsInterface.checkEquipmentCode(s_number, code);
            if (checkEquipmentCode == 1) {
                result.setMsg("Success");
                result.setStatus(100);
                log.info(logText + ",检验成功");
            } else {
                result.setMsg("Wrong");
                result.setStatus(200);
                log.info(logText + ",检验失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.info(logText + "操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "录入学生当前设备号接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：录入成功；\n\n" +
                    "200：录入失败；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "code", value = "设备码", required = true, dataType = "String", paramType = "String"),

    }
    )
    @RequestMapping(value = "/uploadEquipmentCode", method = RequestMethod.POST)
    public Result uploadEquipmentCode(@Param("s_number") int s_number, @Param("code") String code) {
        String logText = "请求录入学号为：" + s_number + "的设备码";
        Result result = new Result();
        try {
            int statusNum = studentsInterface.uploadEquipmentCode(s_number, code);
            if (statusNum == 1) {

                result.setMsg("Success");
                result.setStatus(100);
                log.info(logText + ",录入成功");
            } else if (statusNum == 0) {
                result.setMsg("Wrong");
                result.setStatus(200);
                log.info(logText + ",录入失败，已经有设备码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }


    @ApiOperation(
            value = "上传头像接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：上传成功；\n\n" +
                    "200：上传的文件为空；\n\n" +
                    "400：上传的文件超过5MB；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "headPortrait", value = "学生头像", required = true, dataType = "File", paramType = "File"),

    }
    )
    @RequestMapping(value = "/uploadHeadPortrait", method = RequestMethod.POST)
    public Result uploadHeadPortrait(@Param("s_number") int s_number, @Param("headPortrait") MultipartFile headPortrait) {
        String logText = "上传学号为" + s_number + "的头像";
        Result result = new Result();
        try {
            if (headPortrait.isEmpty()) {
                result.setStatus(200);
                result.setMsg("文件不能为空");
                log.warn("★上传的文件为空！★");
            } else {
                if (headPortrait.getSize() > 5242880) {
                    result.setStatus(400);
                    result.setMsg("图片最大不超过5MB");
                    log.warn("★上传的文件超过5MB！★");
                } else {
                    String fileName = headPortrait.getOriginalFilename();  // 获取到的文件名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                    String filePath = uploadLocation; // 上传后的路径
                    fileName = UUID.randomUUID() + suffixName; // 随机生成的新文件名加上后缀名
                    File dest = new File(filePath + fileName);//dest是绝对路径
                    if (!dest.getParentFile().exists()) {//判断是否存在上级目录（/Upload/image/)
                        dest.getParentFile().mkdirs();//否则创建目录
                    }
                    try {
                        headPortrait.transferTo(dest);//将新的图片存入磁盘中
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    studentsInterface.uploadHeadPortrait(s_number, fileName);
                    result.setMsg("Success");
                    result.setStatus(100);
                    log.info(logText + "，上传成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.info(logText + "，操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "修改密码接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：修改成功；\n\n" +
                    "200：密码错误；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "old_pwd", value = "旧密码", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "new_pwd", value = "新密码", required = true, dataType = "String", paramType = "String"),
    }
    )
    @RequestMapping(value = "/changeStudentPWD", method = RequestMethod.POST)
    public Result changeStudentPWD(@Param("s_number") int s_number, @Param("old_pwd") String old_pwd, @Param("new_pwd") String new_pwd) {
        String logText = "修改学号为：" + s_number + "的密码";
        Result result = new Result();
        try {
            int statusNum = studentsInterface.changeStudentPWD(s_number, old_pwd, new_pwd);
            if (statusNum == 1) {

                result.setMsg("Success");
                result.setStatus(100);
                log.info(logText + "，修改成功");
            } else if (statusNum == 0) {
                result.setMsg("Wrong");
                result.setStatus(200);
                log.info(logText + "，密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }


    @ApiOperation(
            value = "修改休假日接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：修改成功；\n\n" +
                    "200：修改失败，周末无法更改；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "day", value = "周六或者周日周六：1，周日：0", required = true, dataType = "Int", paramType = "Int")
    }
    )
    @RequestMapping(value = "/changeVacationDay", method = RequestMethod.POST)
    public Result changeVacationDay(@Param("s_number") int s_number, @Param("day") int day) {
        String logText = "请求修改学号为：" + s_number + "的休假日";
        Result result = new Result();
        try {
            int statusNum = studentsInterface.changeVacationDay(s_number, day);
            if (statusNum == 1) {

                result.setMsg("Success");
                result.setStatus(100);
                log.info(logText + ",修改成功");
            } else if (statusNum == 0) {
                result.setMsg("Wrong");
                result.setStatus(200);
                log.info(logText + ",修改失败，周六周日无法更改");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作异常");
        }
        return result;
    }

    @ApiOperation(
            value = "注册接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：注册成功；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "name", value = "学生姓名", required = true, dataType = "String", paramType = "String"),
    }
    )
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@Param("s_number") int s_number, @Param("name") String name) {
        String logText = "学号为：" + s_number + ",姓名为:" + name + "的用户请求注册";
        Result result = new Result();
        try {
            studentsInterface.register(s_number, name);
            result.setMsg("Success");
            result.setStatus(100);
            log.info(logText + ",注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }

    @ApiOperation(
            value = "登录接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：登录成功；\n\n" +
                    "200：登录失败；\n\n" +
                    "300：操作出现异常；\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_number", value = "学生学号", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "String"),
    }
    )

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@Param("s_number") int s_number, @Param("pwd") String pwd) {
        String logText = "学号为：" + s_number + "的同学请求登录";
        Result result = new Result();
        try {
            int login = studentsInterface.login(s_number, pwd);
            if (login == 1) {
                result.setMsg("Success");
                result.setStatus(100);
                log.info(logText + ",登录成功");
            } else {
                result.setMsg("Wrong");
                result.setStatus(200);
                log.info(logText + ",登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(300);
            log.error(logText + ",操作出现异常");
        }
        return result;
    }

}