package com.bkb.management.backend.business.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.domain.mapper.login.LoginUserInfoMapper;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
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
}
