package com.dubbo.framework;

import com.dubbo.protocol.http.HttpClient;
import com.dubbo.register.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pansw
 */
public class ProxyFactory {
	public static <T> T getProxy(final Class interfaceClass) {

		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
				Protocol protocol= ProtocolFactory.getProtocol();

				// Url url = RemoteRegister.random(interfaceClass.getName());
				//本地模拟 两个线程没法通用  实际情况用 zookeeper redis 中间件传递存储
				Url url=new Url("localhost",8080);
				String result = protocol.send(url, invocation);
				return result;
			}
		});
	}



}
