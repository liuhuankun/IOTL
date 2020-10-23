package com.wulianwang.iotl.Controller;

import com.wulianwang.iotl.Bean.Students;
import com.wulianwang.iotl.Interface.ClockInterface;
import com.wulianwang.iotl.Interface.StudentsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-10-22 19:59
 */
@Component
@Slf4j
@RestController
public class ScheduledTask {
    @Autowired
    ClockInterface clockInterface;
    @Autowired
    StudentsInterface studentsInterface;

    @Scheduled(cron = "1 45 9 * * 1,7")
    public void cron_1() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 09:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 09:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 09:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 11 * * 1,7")
    public void cron_2() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 11:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 11:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 11:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 13 * * *")
    public void cron_3() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 13:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 13:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 13:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 15 * * *")
    public void cron_4() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 15:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 15:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 15:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 16 * * *")
    public void cron_5() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 16:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 16:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 16:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 16 * * *")
    public void cron_6() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 18:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 18:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 18:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 45 21 * * *")
    public void cron_7() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 21:44:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 21:44:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 21:44:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 15 15 * * *")
    public void cron_8() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 15:14:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 15:14:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 15:14:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

    @Scheduled(cron = "1 15 20 * * *")
    public void cron_9() {
        try {
            List<Students> allStudents = studentsInterface.getAllStudents();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Students student : allStudents) {
                String logText = "学号为" + student.getS_number();
                int statusNum1 = clockInterface.SignIn(student.getS_number(), formatter.format(new Date()) + " 20:14:59");
                if (statusNum1 == 0) {
                    clockInterface.unSignIn(student.getS_number(), formatter.format(new Date()) + " 20:14:59");
                    log.info(logText + "的签到状态是未签到");
                } else if (statusNum1 == 1) {
                    clockInterface.unSignOut(student.getS_number(), formatter.format(new Date()) + " 20:14:59");
                    log.info(logText + "的签到状态是未签退");
                } else {
                    log.info(logText + "的签到状态正常");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作异常");
        }

    }

}