package com.bkb.management.backend.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author big kevin bro
 */
@Data
@ApiModel("测试入参")
public class TestVO implements Serializable {

    @ApiModelProperty("测试文本")
    private String text;
}
