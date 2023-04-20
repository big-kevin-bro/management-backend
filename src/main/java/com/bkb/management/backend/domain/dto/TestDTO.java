package com.bkb.management.backend.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("测试出参")
public class TestDTO implements Serializable {

    @ApiModelProperty("结果")
    private String result;
}
