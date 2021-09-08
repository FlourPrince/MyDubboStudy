package com.dubbo.consumer.controller;

import com.dubbo.consumer.service.ConsumerService;
import com.dubbo.consumer.serviceImpl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pansw
 */
@Controller
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@ResponseBody
	@RequestMapping(path = "/buy")
	public String buy() {

		consumerService.buy();

		return "买票成功";
	}

	@RequestMapping(path = "/buy1")
	@ResponseBody
	public String buy1() {
		return "buy1";
	}

}
