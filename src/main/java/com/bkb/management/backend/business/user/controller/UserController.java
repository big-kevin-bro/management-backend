package com.bkb.management.backend.business.user.controller;

import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.dto.login.LoginUserInfoDTO;
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
@Api(tags = "用户")
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private LoginUserInfoService loginUserInfoService;

    @GetMapping("/get/by/token")
    @ApiOperation("根据token获取用户信息")
    public BaseResponse<LoginUserInfoDTO, ?> getUserInfoByToken() {
        return BaseResponse.success(loginUserInfoService.getUserInfoByToken());
    }
}
