package com.bkb.management.backend.business.login.controller;

import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.config.utils.JwtUtil;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import com.bkb.management.backend.domain.vo.login.LoginUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author big kevin bro
 */
@RestController
@Api(tags = "登录")
@RequestMapping("/sign")
public class LoginController {

    @Resource
    private LoginUserInfoService loginUserInfoService;

    @PostMapping("/up")
    @ApiOperation("用户注册")
    public BaseResponse<Boolean, ?> signUp(@RequestBody LoginUserVO vo) {
        return loginUserInfoService.signUp(vo);
    }

    @PostMapping("/in")
    @ApiOperation("用户登录")
    public BaseResponse<String, ?> signIn(LoginUserVO vo) {
        return loginUserInfoService.signIn(vo);
    }

    @GetMapping("/test")
    @ApiOperation("rsa加密")
    public BaseResponse<String, ?> test(@RequestParam("password") String password) {
        return loginUserInfoService.test(password);
    }
}
