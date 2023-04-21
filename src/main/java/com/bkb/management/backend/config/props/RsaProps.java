package com.bkb.management.backend.config.props;

import lombok.Data;

/**
 * RSA配置
 *
 * @author big kevin bro
 */
@Data
public class RsaProps {

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;
}
