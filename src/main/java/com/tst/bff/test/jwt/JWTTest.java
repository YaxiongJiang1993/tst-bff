package com.tst.bff.test.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTTest {

    static String secret = "12345";

    public static void main(String[] args) {
//        sign();
        parseSign();
    }

    public static String sign() {
        long time = System.currentTimeMillis();
        String token = JWT.create()
                //.withHeader(new HashMap<>())//Header
                .withClaim("userId", 123)//PayLoad
                .withClaim("userName", "程")
                .withClaim("userId1", "456")
                .withClaim("time", time)
//                .withExpiresAt(calendar.getTime())//过期时间
                .sign(Algorithm.HMAC256(secret));//签名用的密钥secret
        System.out.println(token);

        return token;
    }

    public static void parseSign() {
        String token = sign();
        //创建解析对象，使用的算法和secret要和创建token时保持一致
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        System.out.println(decodedJWT.getPayload());//base64编码的payLoad
        Claim userIdInt = decodedJWT.getClaim("userId");
        Claim userIdString = decodedJWT.getClaim("userId1");
        Claim userName = decodedJWT.getClaim("userName");
        Claim time = decodedJWT.getClaim("time");
        System.out.println("userIdInt:" + userIdInt.asInt());
        System.out.println("userIdString:" + userIdString.asString());
        System.out.println("userName:" + userName.asString());
        System.out.println("time:" + time.asLong());
    }

}


