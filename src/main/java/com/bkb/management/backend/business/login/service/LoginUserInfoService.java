package com.bkb.management.backend.business.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.dto.login.LoginUserInfoDTO;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import com.bkb.management.backend.domain.vo.login.LoginUserVO;

/**
 * @author big kevin bro
 */
public interface LoginUserInfoService extends IService<LoginUserInfoDO> {
    LoginUserInfoDO getByUserName(String userName);

    BaseResponse<Boolean, ?> signUp(LoginUserVO vo);

    LoginUserInfoDTO getUserInfoByToken();

    BaseResponse<String,?> test(String password);
}
