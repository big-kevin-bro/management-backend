package com.bkb.management.backend.domain.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bkb.management.backend.domain.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息表
 * @author big kevin bro
 */
@TableName(value ="b_user_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoDO extends BaseDO {

    /**
     * 主键id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;
}