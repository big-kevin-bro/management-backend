package com.bkb.management.backend.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author big kevin bro
 */
@Data
public class BaseResponse<T, V> implements Serializable {
    private Boolean success;
    private String code;
    private String message;
    private T data;
    private V extend;
    private String debugMessage;
    private String debugTrace;

    public BaseResponse() {
    }

    public BaseResponse(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BaseResponse(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Boolean success, String code, String message, T data, V extend, String debugMessage) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.extend = extend;
        this.debugMessage = debugMessage;
    }

    public BaseResponse(Boolean success, String code, String message, T data, V extend) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.extend = extend;
    }

    public static <T, V> BaseResponse<T, V> success(T data) {
        return new BaseResponse<>(true, "0", null, data, null, "");
    }

    public static <T, V> BaseResponse<T, V> success(T data, V extend) {
        return new BaseResponse<>(true, "0", null, data, extend);
    }

    public static <T, V> BaseResponse<T, V> success(String code, T data) {
        return new BaseResponse<>(true, code, null, data);
    }

    public static <T, V> BaseResponse<T, V> success(String code, T data, V extend) {
        return new BaseResponse<>(true, code, null, data, extend);
    }

    public static <T, V> BaseResponse<T, V> success(String code, String message, T data) {
        return new BaseResponse<>(true, code, message, data);
    }

    public static <T, V> BaseResponse<T, V> success(String code, String message, T data, V extend) {
        return new BaseResponse<>(true, code, message, data, extend);
    }

    public static <T, V> BaseResponse<T, V> fail(String code, String message) {
        return new BaseResponse<>(false, code, message, null);
    }

    public static <T, V> BaseResponse<T, V> fail(String code, String message, T data, V extend) {
        return new BaseResponse<>(false, code, message, data, extend);
    }

    public static <T, V> BaseResponse<T, V> fail(String code, String message, String debugMessage) {
        return new BaseResponse<>(false, code, message, null, null, debugMessage);
    }
}
