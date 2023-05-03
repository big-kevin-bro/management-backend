package com.bkb.management.backend.config.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author big kevin bro
 */
@Component
@Slf4j
public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "big_kevin_bro";

    /**
     * 过期时间，单位为秒
     **/
    private static final long EXPIRATION = 1800L;

    /**
     * 生成用户token,设置token超时时间
     */
    public static String createToken(LoginUserInfoDO loginUserInfo) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                // 添加头部
                .withHeader(map)
                // 将userId放到claims中
                .withClaim("id", loginUserInfo.getId())
                // 超时设置,设置过期的日期
                .withExpiresAt(expireDate)
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token并解析token
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt;
        try {
            // 去除Bearer
            String substring = token.substring(7);
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(substring);
            // decodedJWT.getClaim("属性").asString()  获取负载中的属性值
        } catch (Exception e) {
            // 解码异常则抛出异常
            log.error("token解码异常: ", e);
            return null;
        }
        return jwt.getClaims();
    }

    public static String getUserIdByToken(String token) {
        if(StringUtils.isBlank(token)) {
            return null;
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaims().get("id").asString();
    }
}
