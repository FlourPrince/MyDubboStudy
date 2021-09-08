package com.dubbo.provider;

import com.alibaba.dubbo.config.*;
import com.dubbo.provider.api.ProviderService;
import com.dubbo.provider.impl.ProviderServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pansw
 */
public class MyProvider {

	public static void main(String[] args) {
		// 服务实现
		ProviderService providerService = new ProviderServiceImpl();
		// 当前应⽤配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("MyProvider");
		// 连接注册中⼼配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("127.0.0.1:2181");
		registry.setProtocol("zookeeper");

		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20880);
		protocol.setThreads(200);

		// ⽅法级配置
		List<MethodConfig> methods = new ArrayList<MethodConfig>();
		MethodConfig method = new MethodConfig();
		method.setName("sale");
		method.setTimeout(10000);
		method.setRetries(0);
		methods.add(method);

		// 注意：ServiceConfig为重对象，内部封装了与注册中⼼的连接，以及开启服务端⼝
		// 服务提供者暴露服务配置
		ServiceConfig<ProviderService> service = new ServiceConfig<ProviderService>();
		//// 此实例很重，封装了与注册中⼼的连接，请⾃⾏缓存,否则可能造成内存和连接泄漏
		service.setApplication(application);
		// 多个注册中⼼可以⽤setRegistries()
		service.setRegistry(registry);
		// 多个协议可以⽤setProtocols()
		service.setProtocol(protocol);
		service.setInterface(ProviderService.class);
		service.setRef(providerService);
		service.setVersion("1.0.0");
		service.setMethods(methods);
		// 暴露及注册服务
		service.export();

		System.out.println("暴露服务结束");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
