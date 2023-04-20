package com.bkb.management.backend.config.interceptor;

import cn.hutool.core.lang.UUID;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author big kevin bro
 */
@Component
public class TraceIdInterceptor implements HandlerInterceptor {

    private static final String REQUEST_ID = "requestId";

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, HttpServletResponse response, @NonNull Object handler) {
        String requestId = this.getRequestId(request);
        MDC.put(REQUEST_ID, requestId);
        // 将traceId添加进响应头
        response.addHeader(REQUEST_ID,requestId);
        return true;
    }

    private String getRequestId(HttpServletRequest request){
        return String.format("%s - %s", request.getRequestURI(), UUID.randomUUID());
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, HttpServletResponse response, @NonNull Object handler, @Nullable Exception ex) {
        response.getTrailerFields();
    }
}
