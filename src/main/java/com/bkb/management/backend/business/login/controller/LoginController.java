package com.bkb.management.backend.business.login.controller;

import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.config.utils.JwtUtil;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import com.bkb.management.backend.domain.vo.login.LoginUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author big kevin bro
 */
@RestController
@Api(tags = "登录")
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginUserInfoService loginUserInfoService;

    @PostMapping("")
    @ApiOperation("用户登录")
    public BaseResponse<String, ?> login(LoginUserVO vo) {
        LoginUserInfoDO loginUserInfo = loginUserInfoService.getByUserName(vo.getUserName());
        if (loginUserInfo == null) {
            return BaseResponse.fail("401", "用户未注册");
        }
        if (loginUserInfo.getPassword().equals(vo.getPassword())) {
            String token = JwtUtil.createToken(loginUserInfo);
            return BaseResponse.success(token);
        } else {
            return BaseResponse.fail("401", "登录密码错误");
        }
    }
}
