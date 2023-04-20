package com.bkb.management.backend.business.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;

/**
 * @author big kevin bro
 */
public interface LoginUserInfoService extends IService<LoginUserInfoDO> {
    LoginUserInfoDO getByUserName(String userName);
}
