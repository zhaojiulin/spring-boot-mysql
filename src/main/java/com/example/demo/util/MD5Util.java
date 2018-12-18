package com.example.demo.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String GetMD5Code(String str) {
		MessageDigest md5;
		String newstr = "";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder encoder = new BASE64Encoder();
			try {
				newstr = encoder.encode(md5.digest(str.getBytes("utf-8")));
				newstr = newstr.replaceAll("=", "");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return newstr;
	}


	public static String md5(String data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(data.toString().getBytes());
		return bytesToHex(md.digest());
	}

	public static String bytesToHex(byte[] ch) {
		StringBuffer ret = new StringBuffer("");
		for (int i = 0; i < ch.length; i++)
			ret.append(byteToHex(ch[i]));
		return ret.toString();
	}

	/**
	 * 字节转换为16进制字符串
	 */
	public static String byteToHex(byte ch) {
		String str[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B",
				"C", "D", "E", "F"};
		return str[ch >> 4 & 0xF] + str[ch & 0xF];
	}
}
