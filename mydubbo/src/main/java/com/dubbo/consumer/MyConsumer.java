package com.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.provider.api.ProviderService;

/**
 * @author pansw
 */
public class MyConsumer {

	public static void main(String[] args) {
		// 当前应⽤配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("MyConsumer");

		// 连接注册中⼼配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("127.0.0.1:2181");
		registry.setProtocol("zookeeper");

		// 注意：ReferenceConfig为重对象，内部封装了与注册中⼼的连接，以及与服务提供⽅的连接
		// 引⽤远程服务
		ReferenceConfig<ProviderService> reference = new ReferenceConfig<ProviderService>();
		// 此实例很重，封装了与注册中⼼的连接以及与提供者的连接，请⾃⾏缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		// 多个注册中⼼可以⽤setRegistries()
		reference.setRegistry(registry);
		reference.setInterface(ProviderService.class);
		reference.setVersion("1.0.0");
		// 和本地bean⼀样使⽤xxxService
		// 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复⽤
		ProviderService providerService = reference.get();
		providerService.sale("张三");

		System.out.println("消费结束");
	}
}
