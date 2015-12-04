package com.dxj.xuer.common;

import javax.servlet.http.HttpServletRequest;

/**
 * ���󹤾���
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public final class RequestUtils {
	
	/**
	 * ��ȡ����ͻ���IP
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request){
		String address = request.getHeader("X-Forwarded-For");
		if (address != null && address.length() > 0
				&& !"unknown".equalsIgnoreCase(address)) {
			return address;
		}
		address = request.getHeader("Proxy-Client-IP");
		if (address != null && address.length() > 0
				&& !"unknown".equalsIgnoreCase(address)) {
			return address;
		}
		address = request.getHeader("WL-Proxy-Client-IP");
		if (address != null && address.length() > 0
				&& !"unknown".equalsIgnoreCase(address)) {
			return address;
		}
		return request.getRemoteAddr();
	}
}
