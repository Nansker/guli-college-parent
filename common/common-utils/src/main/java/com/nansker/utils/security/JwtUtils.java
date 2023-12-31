package com.nansker.utils.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Nansker
 * @date 2023/9/17 0:53
 * @description JWT工具类
 */
public class JwtUtils {
	public static final long EXPIRE = 1000 * 60 * 60 * 24;
	public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

	/**
	 * @param id
	 * @param nickname
	 * @return java.lang.String
	 * @author Nansker
	 * @date 2023/9/18 0:43
	 * @description 生成token
	 */
	public static String getJwtToken(String id, String nickname) {
		String JwtToken = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256").setSubject("user").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRE)).claim("id", id).claim("nickname", nickname).signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
		return JwtToken;
	}

	/**
	 * @param jwtToken
	 * @return
	 * @description 判断token是否存在与有效
	 */
	public static boolean checkToken(String jwtToken) {
		if (StringUtils.isEmpty(jwtToken))
			return false;
		try {
			Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param request
	 * @return
	 * @description 判断token是否存在与有效
	 */
	public static boolean checkToken(HttpServletRequest request) {
		try {
			String jwtToken = request.getHeader("token");
			if (StringUtils.isEmpty(jwtToken))
				return false;
			Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param request
	 * @return
	 * @description 根据token获取会员id
	 */
	public static String getUserIdByToken(HttpServletRequest request) {
		String jwtToken = request.getHeader("token");
		if (StringUtils.isEmpty(jwtToken))
			return "";
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
		Claims claims = claimsJws.getBody();
		return (String) claims.get("id");
	}

}
