package com.bkb.management.backend.business.exception.controller;

import com.bkb.management.backend.business.exception.service.ExceptionDemoService;
import com.bkb.management.backend.domain.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author big kevin bro
 */
@RestController
@Api(tags = "统一异常处理")
@RequestMapping("/api/exception")
public class ExceptionDemoController {

    @Resource
    private ExceptionDemoService exceptionDemoService;

    @GetMapping("/test")
    @ApiOperation("测试")
    public BaseResponse<Boolean, ?> exceptionDemo() {
        return BaseResponse.success(exceptionDemoService.exceptionDemo());
    }
}
