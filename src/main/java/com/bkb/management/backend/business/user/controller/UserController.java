package com.bkb.management.backend.business.user.controller;

import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.business.user.service.UserInfoService;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.dto.login.LoginUserInfoDTO;
import com.bkb.management.backend.domain.dto.user.UserInfoDTO;
import com.bkb.management.backend.domain.vo.user.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author big kevin bro
 */
@RestController
@Api(tags = "用户")
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private LoginUserInfoService loginUserInfoService;

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public BaseResponse<Boolean, ?> add(@RequestBody UserInfoVO vo) {
        return BaseResponse.success(userInfoService.add(vo));
    }

    @PostMapping("/update")
    @ApiOperation("更新用户")
    public BaseResponse<Boolean, ?> updateUser(@RequestBody UserInfoVO vo) {
        return BaseResponse.success(userInfoService.updateUser(vo));
    }

    @GetMapping("/get")
    @ApiOperation("获取用户信息")
    public BaseResponse<List<UserInfoDTO>, ?> getUserInfo(UserInfoVO vo) {
        return BaseResponse.success(userInfoService.getUserInfo(vo));
    }

    @GetMapping("/get/by/token")
    @ApiOperation("根据token获取用户信息")
    public BaseResponse<LoginUserInfoDTO, ?> getUserInfoByToken() {
        return BaseResponse.success(loginUserInfoService.getUserInfoByToken());
    }
}
