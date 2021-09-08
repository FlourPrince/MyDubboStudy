package com.dubbo.consumer.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.consumer.service.ConsumerService;
import com.providerapi.api.service.providerService;
import org.springframework.stereotype.Service;

/**
 * @author pansw
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Reference
	providerService providerService;

	@Override
	public void buy() {
		providerService.sale();

		System.out.println("消费者买票");
	}

}
