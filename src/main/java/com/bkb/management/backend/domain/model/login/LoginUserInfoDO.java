package com.bkb.management.backend.domain.model.login;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.bkb.management.backend.domain.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author big kevin bro
 */
@TableName(value ="b_login_user_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginUserInfoDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}