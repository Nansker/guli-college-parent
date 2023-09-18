package com.nansker.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author Nansker
 * @date 2023/9/18 19:16
 * @description 密码加密工具类
 */
public class PasswordUtils {

	/**
	 * 随机的字符和数字
	 */
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 盐值长度
	 */
	private static final int SALT_LENGTH = 6;

	/**
	 * @author Nansker
	 * @date 2023/9/18 20:15
	 * @return java.lang.String
	 * @description 生成盐值
	*/
	public static String generateSalt() {
		return getString(SALT_LENGTH);
	}

	/**
	 * @author Nansker
	 * @date 2023/9/18 20:14
	 * @param password 原始密码
	 * @param salt 加密盐
	 * @return java.lang.String
	 * @description 将密码进行MD5加盐加密
	*/
	public static String hashPassword(String password, String salt) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(Integer.toString((b & 0xff) + 0x100, SALT_LENGTH).substring(1));
			}
			hash = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash;
	}
	/**
	 * @author Nansker
	 * @date 2023/9/18 20:15
	 * @param password 原始密码
	 * @param salt 盐值
	 * @param hashedPassword 加密后的密码
	 * @return boolean
	 * @description 比较密码是否相同
	*/
	public static boolean verifyPassword(String password, String salt, String hashedPassword) {
		String newHash = hashPassword(password, salt);
		return newHash.equals(hashedPassword);
	}

	/**
	 * 返回一个定长的随机字符串(只包含大小写字母、数字)
	 *
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static String getString(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}

}
