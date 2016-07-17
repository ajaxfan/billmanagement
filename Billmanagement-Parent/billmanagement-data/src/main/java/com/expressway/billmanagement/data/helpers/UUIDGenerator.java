package com.expressway.billmanagement.data.helpers;

import java.util.UUID;

/**
 * UUID生成工具
 * 
 * @author Kalo
 */
public final class UUIDGenerator {
	/**
	 * @return 随机生成UUID
	 */
	public static String random() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
