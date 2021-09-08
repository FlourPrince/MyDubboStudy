package com.dubbo.consumer;


import com.dubbo.framework.Invocation;
import com.dubbo.framework.Protocol;
import com.dubbo.framework.ProtocolFactory;
import com.dubbo.framework.ProxyFactory;
import com.dubbo.protocol.http.HttpClient;
import com.dubbo.provider.api.ProviderService;

/**
 * @author pansw
 */
public class Consumer {

	public static void main(String[] args) {

		//消费调用方法

		ProviderService providerService= ProxyFactory.getProxy(ProviderService.class);



		System.out.println(providerService.sale("李四"));

	}
}
