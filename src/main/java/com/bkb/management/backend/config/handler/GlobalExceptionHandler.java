package com.bkb.management.backend.config.handler;

import com.bkb.management.backend.config.exception.BusinessHintException;
import com.bkb.management.backend.constants.enums.BusinessExceptionEnum;
import com.bkb.management.backend.domain.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author big kevin bro
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleException(Exception e) {
        // 处理异常
        return BaseResponse.fail(BusinessExceptionEnum.INTERNAL_SERVER_ERROR.getCode(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ExceptionHandler(value = BusinessHintException.class)
    public BaseResponse handleBusinessException(BusinessHintException e) {
        // 业务异常
        return BaseResponse.fail(e.getErrorCode(), e.getErrorMessage());
    }
}
