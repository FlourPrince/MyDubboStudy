package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.dubbo.framework.Invocation;
import com.dubbo.framework.Protocol;
import com.dubbo.framework.Url;

public class MyProtocol  implements ProtocolInterface {

	@Override
	public void start(URL url) {
		System.out.println("MyProtocol.start");
	}
}
