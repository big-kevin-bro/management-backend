package com.bkb.management.backend.domain.vo.user;

import com.bkb.management.backend.domain.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author big kevin bro
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户信息入参")
public class UserInfoVO extends BaseVO {

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("备注")
    private String remarks;
}
