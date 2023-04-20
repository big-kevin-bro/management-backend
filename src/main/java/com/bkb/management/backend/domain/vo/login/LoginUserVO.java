package com.bkb.management.backend.domain.vo.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author big kevin bro
 */
@Data
@ApiModel("登录用户信息")
public class LoginUserVO implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
