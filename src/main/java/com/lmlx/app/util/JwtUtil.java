package com.lmlx.app.util;

import com.lmlx.app.model.so.ManageUserInfoSo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author jiahao jin
 * @create 2020-12-29 14:39
 */
@Component
public class JwtUtil {
    private static final String TOKEN_SECRET = "JO6HN3NGIU25G2FIG8V7VD6CK9B6T2Z5";

    @Value("${manage.expire_time}")
    private String outTime;

    private static Long EXPIRE_TIME;

    @PostConstruct
    public void init() {
        EXPIRE_TIME = Long.valueOf(outTime);
    }

    public static String encryption(String password) {
//        return MD5Util.encrypt(password);
        return  MD5Util.encrypt(password);
    }

    public static String sign(Long userId) {

        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + EXPIRE_TIME);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(String.valueOf(userId))
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();

    }

    public static Claims verify(String token){
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        try {
            return Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){

            return null;
        }
    }

    /**
     *
     * @param token
     * @return
     * @throws Exception
     * @message false 不过期
     */
    public static boolean isOverdue(String token) throws Exception {
        Claims claims = verify(token);
        if(null == claims) {
            return true;
        }
        return claims.getExpiration().before(new Date());
    }

    public static void main(String[] args) throws Exception {
//        XwUserInfo xwUserInfo = new XwUserInfo();
//        xwUserInfo.setUserId("234");
//        String a = sign(xwUserInfo);
//        System.out.println(a);
        String s  = sign(1L);
        System.out.println(isOverdue(s ));
        Thread.sleep(3000);
        System.out.println(isOverdue(s ));
    }
}
