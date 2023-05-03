package com.bkb.management.backend.config.filter;

import cn.hutool.json.JSONUtil;
import com.auth0.jwt.interfaces.Claim;
import com.bkb.management.backend.config.utils.JwtUtil;
import com.bkb.management.backend.constants.enums.BusinessExceptionEnum;
import com.bkb.management.backend.domain.base.BaseResponse;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/**
 * JWT过滤器，拦截所有的请求
 *
 * @author big kevin bro
 */
@Slf4j
@WebFilter(filterName = "JwtFilter", urlPatterns = "/api/*")
public class JwtFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        // 获取 header里的token
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        // Except OPTIONS, other request should be checked by JWT
        else {
            if (token == null) {
                String errorMessage = JSONUtil.toJsonStr(
                        BaseResponse.fail(BusinessExceptionEnum.HTTP_UNAUTHORIZED.getCode(), "token为空"));
                response.getWriter().write(errorMessage);
                return;
            }

            Map<String, Claim> userData = JwtUtil.verifyToken(token);
            if (userData == null) {
                String errorMessage = JSONUtil.toJsonStr(
                        BaseResponse.fail(BusinessExceptionEnum.HTTP_UNAUTHORIZED.getCode(), "token不合法"));
                response.getWriter().write(errorMessage);
                return;
            }
            String userId = userData.get("id").asString();
            // 拦截器拿到用户userId，放到request中
            request.setAttribute("id", userId);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
