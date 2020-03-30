package com.rtst.dhjc.config;

import com.rtst.dhjc.Interceptor.CorsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 实现基本的跨域请求
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Resource
    private CorsInterceptor corsInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 跨域拦截器需放在最上面
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
    }

}
