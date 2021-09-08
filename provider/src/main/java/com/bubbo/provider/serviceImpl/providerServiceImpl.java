package com.bubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.providerapi.api.service.providerService;
import org.springframework.stereotype.Component;

@Component
@Service
public class providerServiceImpl implements providerService {

	//@HystrixCommand
	@Override
	public void sale() {
		System.out.println("售货员卖票");
	}
}
