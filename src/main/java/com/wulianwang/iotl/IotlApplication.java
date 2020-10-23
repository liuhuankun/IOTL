package com.wulianwang.iotl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableSwagger2
@Slf4j
@EnableScheduling
public class IotlApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotlApplication.class, args);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("运行成功"+formatter.format(new Date()));
    }

}
