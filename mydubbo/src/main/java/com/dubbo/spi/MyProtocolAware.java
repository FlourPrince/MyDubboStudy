package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.dubbo.framework.Invocation;
import com.dubbo.framework.Url;


public class MyProtocolAware implements ProtocolInterface {
	ProtocolInterface protocol;

	public MyProtocolAware(ProtocolInterface protocol){
		this.protocol=protocol;
	}


	@Override
	public void start(URL url) {
		System.out.println("MyProtocolAware.start");
		protocol.start( url);
	}
}
