package com.bkb.management.backend.config;

import com.bkb.management.backend.config.interceptor.TraceIdInterceptor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author big kevin bro
 */
@Component
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private TraceIdInterceptor traceIdInterceptor;

    /*
      traceId 拦截器需要在最开始执行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceIdInterceptor).order(0);
    }
}
