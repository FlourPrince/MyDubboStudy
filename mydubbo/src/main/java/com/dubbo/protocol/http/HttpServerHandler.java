package com.dubbo.protocol.http;

import com.dubbo.framework.Invocation;
import com.dubbo.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pansw
 */
public class HttpServerHandler {

	public void handler(HttpServletRequest req, HttpServletResponse resp) {
           //处理请求
		try {
			InputStream inputStream = req.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Invocation invocation = (Invocation) objectInputStream.readObject();

			//1.根据接口名找到实现类
			Class implClass = LocalRegister.get(invocation.getInterfaceName());
			Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
			String result = (String) method.invoke(implClass.newInstance(), invocation.getObjects());

			IOUtils.write(result, resp.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}


	}
}
