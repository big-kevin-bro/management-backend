package com.bkb.management.backend.config.exception;

import com.bkb.management.backend.domain.base.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author big kevin bro
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessHintException extends RuntimeException {

    private String errorCode;

    private String errorMessage;

    private BaseResponse baseResponse;

    public BusinessHintException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public BusinessHintException(BaseResponse baseResponse) {
        super(baseResponse.getMessage());
        this.baseResponse = baseResponse;
        this.errorCode = baseResponse.getCode();
        this.errorMessage = baseResponse.getMessage();
    }

    public static BusinessHintException error(BaseResponse baseResponse) {
        return new BusinessHintException(baseResponse);
    }
}
