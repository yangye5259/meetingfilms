package com.yangye.meetingfilms.common.properties;

import lombok.Data;

/**
 * jwt相关配置
 *
 * @author yangye
 */
@Data
public class JwtProperties {

    private static final JwtProperties jwtProperties = new JwtProperties();

    private JwtProperties() {
    }

    public static JwtProperties getJwtProperties() {
        return jwtProperties;
    }

    public static final String JWT_PREFIX = "jwt";

    private String header = "Authorization";

    private String secret = "defaultSecret";
    /**
     * 默认token的过期时间，7天
     */
    private Long expiration = 604800L;

    private String authPath = "login";

    private String md5Key = "randomKey";
}