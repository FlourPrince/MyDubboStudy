package com.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.provider.api.ProviderService;
import com.providerapi.api.service.providerService;
import org.springframework.stereotype.Component;

/**
 * @author pansw
 */
@Component
@Service
public class ProviderServiceImpl implements ProviderService {
	@Override
	public String sale(String name) {
		System.out.println("服务提供者执行方法");
		return  name+"售货员卖票";
	}
}
