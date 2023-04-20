package com.bkb.management.backend.business.login.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.mapper.login.LoginUserInfoMapper;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import com.bkb.management.backend.domain.vo.login.LoginUserVO;
import org.springframework.stereotype.Service;

/**
 * @author big kevin bro
 */
@Service
public class LoginUserInfoServiceImpl extends ServiceImpl<LoginUserInfoMapper, LoginUserInfoDO> implements LoginUserInfoService {

    /**
     * @param userName 用户名
     * @return 登录用户信息
     */
    @Override
    public LoginUserInfoDO getByUserName(String userName) {
        LambdaQueryWrapper<LoginUserInfoDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LoginUserInfoDO::getUserName, userName);
        return getOne(wrapper);
    }

    /**
     * @param vo 入参
     * @return 是否注册成功
     */
    @Override
    public BaseResponse<Boolean, ?> signUp(LoginUserVO vo) {
        LambdaQueryWrapper<LoginUserInfoDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LoginUserInfoDO::getUserName, vo.getUserName());
        LoginUserInfoDO loginUserInfo = this.getOne(wrapper);
        if (loginUserInfo != null) {
            return BaseResponse.fail("500", "用户名已存在");
        }
        loginUserInfo = new LoginUserInfoDO();
        loginUserInfo.setUserName(vo.getUserName());
        loginUserInfo.setPassword(MD5.create().digestHex(vo.getPassword()));
        return BaseResponse.success(this.save(loginUserInfo));
    }
}
