package com.bkb.management.backend.business.exception.service.impl;

import com.bkb.management.backend.business.exception.service.ExceptionDemoService;
import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.config.exception.BusinessHintException;
import com.bkb.management.backend.constants.enums.BusinessExceptionEnum;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.dto.login.LoginUserInfoDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author big kevin bro
 */
@Service
@Slf4j
public class ExceptionDemoServiceImpl implements ExceptionDemoService {

    @Resource
    private LoginUserInfoService loginUserInfoService;

    @Override
    public Boolean exceptionDemo() {
        log.info("统一异常测试类");
        LoginUserInfoDTO userInfoByToken = loginUserInfoService.getUserInfoByToken();
        if (userInfoByToken != null) {
            throw BusinessHintException.error(
                    BaseResponse.fail(BusinessExceptionEnum.HTTP_UNAUTHORIZED.getCode(), BusinessExceptionEnum.HTTP_UNAUTHORIZED.getDefaultMsg()));
        }
        return true;
    }
}
