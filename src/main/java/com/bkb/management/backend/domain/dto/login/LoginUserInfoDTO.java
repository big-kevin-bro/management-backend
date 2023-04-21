package com.bkb.management.backend.domain.dto.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author big kevin bro
 */
@Data
@ApiModel("登录用户信息出参")
public class LoginUserInfoDTO implements Serializable {

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;
}
