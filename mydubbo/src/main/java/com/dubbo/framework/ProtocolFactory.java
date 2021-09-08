package com.dubbo.framework;

import com.dubbo.protocol.dubbo.DubboProtocol;
import com.dubbo.protocol.http.HttpProtocol;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author pansw
 */
public class ProtocolFactory {

	public static Protocol getProtocol() {
		//工厂模式
		String name = System.getProperty("protocolName");

		if (name == null || name.equals("")) {
			name = "http";
		}

		switch (name) {
			case "http":
				return new HttpProtocol();

			case "dubbo":
				return new DubboProtocol();

			default:
				break;
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
