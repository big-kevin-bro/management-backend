package com.bkb.management.backend.domain.model.rsa;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bkb.management.backend.domain.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户RSA秘钥对表
 * @author big kevin bro
 */
@TableName(value ="b_user_rsa_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRsaInfoDO extends BaseDO {
    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;
}