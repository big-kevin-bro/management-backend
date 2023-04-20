package com.bkb.management.backend.business.demo.controller;

import com.bkb.management.backend.business.demo.service.DemoService;
import com.bkb.management.backend.domain.dto.TestDTO;
import com.bkb.management.backend.domain.vo.TestVO;
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
@RequestMapping("/demo")
@Api(tags = "测试")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/test")
    @ApiOperation("测试接口")
    public TestDTO test(TestVO vo) {
        return demoService.test(vo);
    }
}
