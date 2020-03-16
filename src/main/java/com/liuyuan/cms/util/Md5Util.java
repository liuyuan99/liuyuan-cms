package com.liuyuan.cms.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 
 * 
 * @ClassName: Md5Util 
 * @Description: 密码加密处理
 * @author: 刘媛
 * @date: 2020年3月12日 上午10:15:19
 */
public class Md5Util {

	/**
	 * 直接对密码进行散列，那么黑客可以对通过获得这个密码散列值，
	 * 然后通过查散列值字典（例如MD5密码破解网站），得到某用户的密码。
	 * 加Salt可以一定程度上解决这个问题
	 */
	private static String salt = "liuyuan";
	
	public static String encode(String password) {
		//System.out.println(DigestUtils.md5Hex(password+salt));
		return DigestUtils.md5Hex(password+salt);
	}
	
	public static void main(String[] args) {
		Md5Util.encode("123456");
	}
}
