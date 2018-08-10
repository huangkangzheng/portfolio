package com.citi.portfoliomanager.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @ClassName: MD5Util
 * @Description: 加密工具，提供普通md5加密和盐值md5加密
 * @Function List:
 * @author: xtf
 * @version:
 * @Date: 2016/3/4 16:18
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MD5Util {

	private static Md5PasswordEncoder encoder = new Md5PasswordEncoder();

	/**
	 *
	 * @Function: md5
	 * @Description: 带盐值的md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String md5(String str, String salt){
		return encoder.encodePassword(str,salt);
	}
	public static void main(String[] args){
		//System.out.println(md5("123456","24320132202503"));
		System.out.println(md5("123456","24320142202430"));
	}
}
