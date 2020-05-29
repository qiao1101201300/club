package com.demo.club.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET = "session_secret";

    private static final String ISSUER = "chunbo_user";

    //获取token的方法
    public static String genToken(Map<String, Object> claims) {
        try {
            //使用该加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //Builder是JWTCreator的静态内部类
            //{静态内部类只能访问外部类的静态变量和静态方法，Outer.Inner inner = new Outer.Inner()}
            JWTCreator.Builder builder = JWT.create()
                    .withIssuer(ISSUER) //设置发布者
                    .withExpiresAt((Date) claims.get("expiresAt"));//过期一天
            claims.remove("expiresAt");
            for (Map.Entry<String, Object> entry : claims.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().toString());
            }
            //claims.forEach( builder::withClaim);
            return builder.sign(algorithm).toString(); //使用上面的加密算法进行签名，返回String，就是token
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    //验证token方法
    public static Map<String, Object> verifyToken(String token) {
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        DecodedJWT jwt = verifier.verify(token);

        Map<String, Claim> map = jwt.getClaims();
        Date expiresAt = jwt.getExpiresAt();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (Map.Entry<String, Claim> entry : map.entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue().asString());
        }

        resultMap.put("expiresAt", expiresAt);
        return resultMap;
    }

    //验证token方法
    public static DecodedJWT verifyJwt(String token) {
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        DecodedJWT jwt = verifier.verify(token);

        return jwt;
    }

    @Test
    public void decode() {
    }
}

