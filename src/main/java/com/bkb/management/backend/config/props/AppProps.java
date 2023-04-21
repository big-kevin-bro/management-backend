package com.bkb.management.backend.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @author fukai
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProps {

    /**
     * RSA配置
     */
    private RsaProps rsa = new RsaProps();
}
