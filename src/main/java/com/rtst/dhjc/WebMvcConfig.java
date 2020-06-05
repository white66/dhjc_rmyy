package com.rtst.dhjc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/26 11:11
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${swagger.enable}")
    private boolean enableSwagger;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(enableSwagger) {
            // 解决静态资源无法访问
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/");
            // 解决swagger无法访问
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
            // 解决swagger的js文件无法访问
            registry.addResourceHandler("/webjars")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
