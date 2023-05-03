package com.bkb.management.backend.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author big kevin bro
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BusinessExceptionEnum {

    /**
     * 错误码
     */
    HTTP_UNAUTHORIZED("401", "Unauthorized"),
    INTERNAL_SERVER_ERROR("500", "{0}");

    private String code;
    private String defaultMsg;
}
