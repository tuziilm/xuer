package com.dxj.xuer.common;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Hex;

/**
 * ������ع�����
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public final class Encodings {
	/**
	 * ת����Unicode
	 * @param input
	 * @return
	 */
	public static String unicode(String input){
		if(input==null || input.isEmpty()){
			return "";
		}
		try {
			char[] data=Hex.encodeHex(input.getBytes("UNICODE"), false);
			return new String(data,4,data.length-4);
		} catch (UnsupportedEncodingException e) {
			//never happen
		}
		return "";
	}
}
