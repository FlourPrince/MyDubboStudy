package com.dubbo.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pansw
 */
public class LocalRegister {
	private static Map<String, Class> map = new HashMap();

	public static void register(String serviceName, Class implClass) {
		map.put(serviceName, implClass);
	}

	public static Class get(String serviceName) {
		return map.get(serviceName);
	}
}
