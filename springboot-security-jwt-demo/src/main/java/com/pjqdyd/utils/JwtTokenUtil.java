package com.pjqdyd.utils;

import com.pjqdyd.entity.Perm;
import com.pjqdyd.entity.User;
import com.pjqdyd.service.PermService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Jwt相关工具类
 */
@Component
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";    //token中存储用户名的key
    private static final String CLAIM_KEY_CREATED = "created"; //token中存储创建日期的key
    private static final String CLAIM_KEY_PERMS = "perms";     //token中存储权限信息的key

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration}")
    private Long EXPIRATION_TIME;

    @Resource
    private PermService permService;

    /**
     * 根据解密token信息获取用户名, (只有token正确且没有过期才能返回username)
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        if (!isTokenExpired(token)){
            return username;
        }
        return null;
    }

    /**
     * 从token中获取过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000);
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        if (expiration ==  null){
            return false;
        }
        return expiration.before(new Date());
    }

    /**
     * 从token中解密获取权限信息
     * @return
     */
    public String getPermsFromToken(String token){
        String perms;
        try {
            final Claims claims = getClaimsFromToken(token);
            perms = String.valueOf(claims.get(CLAIM_KEY_PERMS));
        } catch (Exception e) {
            perms = null;
        }
        return perms;
    }

    /**
     * 这一步实际上是在根据密钥解密token信息,如果token被篡改了,那么抛异常claims = null
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 根据用户信息生成token
     */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, user.getUsername()); //用户名
        claims.put(CLAIM_KEY_CREATED, new Date());          //生成日期
        //获取用户的权限, 保存到token中, 使用","拼接权限成字符串
        List<Perm> permList = permService.selectAllByUserId(user.getUserId());
        claims.put(CLAIM_KEY_PERMS, permList.stream().map(perm -> perm.getPermName()).collect(Collectors.joining(",")));
        return generateToken(claims);
    }
    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    //刷新token
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    //根据解密token信息获取生成日期
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }
    public Boolean canTokenBeRefreshed(String token) {
        return !isTokenExpired(token);
    }
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
}
