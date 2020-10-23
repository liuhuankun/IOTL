package com.wulianwang.iotl.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lhk
 * @description
 * @create 2020-10-10 15:05
 */
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter {
    @Value("${upload.image.location}")
    private String uploadLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + uploadLocation);
    }
}
