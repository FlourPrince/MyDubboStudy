package com.dubbo.provider;

import com.dubbo.framework.Protocol;
import com.dubbo.framework.ProtocolFactory;
import com.dubbo.framework.Url;
import com.dubbo.protocol.http.HttpServer;
import com.dubbo.provider.api.ProviderService;
import com.dubbo.provider.impl.ProviderServiceImpl;
import com.dubbo.register.RemoteRegister;

/**
 * @author pansw
 */
public class Provider {
	public static void main(String[] args) {
		//1.本地注册
		// 服务名 实现类
		LocalRegister.register(ProviderService.class.getName(), ProviderServiceImpl.class);

		//2.远程注册
		// 服务名 地址
		Url url=new Url("localhost",8080);
		RemoteRegister.register(ProviderService.class.getName(),url);

		//3.启动tomcat
		Protocol protocol= ProtocolFactory.getProtocol();
		protocol.start(url);
	}
}
