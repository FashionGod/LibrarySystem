package com.springboot.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author shang.shi
 *
 */
public class JwtUtil {

	/**
	 * 获取token中的参数
	 *
	 * @param token
	 * @return
	 */
	public static Claims parseToken(String token, String key) {
		if ("".equals(token)) {
			return null;
		}

		try {
			return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key)).parseClaimsJws(token)
					.getBody();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 生成token
	 *
	 * @param userId
	 * @return
	 */
	public static String createToken(Integer userId, String username, int expireMinutes) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=");

		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// long nowMillis = System.currentTimeMillis();
		// Date now = new Date(nowMillis);

		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder()
				// .setHeaderParam("type", "JWT")
				// .setSubject(userId.toString())
				// 设置载荷信息
				.claim("userId", userId).claim("username", username).setIssuedAt(new Date())
				// 设置超时时间
				.setExpiration(DateTime.now().plusMinutes(expireMinutes).toDate())
				.signWith(signatureAlgorithm, signingKey);

		// 生成JWT
		return builder.compact();
	}

	// public static void main(String[] args) {
	//
	// String token = JWTUtil.createToken(1, "zhangsan", 30);
	// String token1 = JWTUtil.createToken(2, "zgsan", 30);
	// System.out.println(token);
	//
	// Claims claims = JWTUtil.parseToken(token, "zhangsan");
	// Claims claims1 = JWTUtil.parseToken(token1, "zgsan");
	// System.out.println(claims);
	// System.out.println(claims1);
	// }

}