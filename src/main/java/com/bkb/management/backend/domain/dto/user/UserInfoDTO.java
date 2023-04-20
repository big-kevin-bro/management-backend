package com.bkb.management.backend.domain.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author big kevin bro
 */
@Data
@ApiModel("用户信息出参")
public class UserInfoDTO implements Serializable {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("备注")
    private String remarks;
}
