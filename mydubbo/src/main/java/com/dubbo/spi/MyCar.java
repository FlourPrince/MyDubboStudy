package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;

public class MyCar implements Car {

	ProtocolInterface protocolInterface;

	public void setProtocolInterface(ProtocolInterface protocolInterface){
		this.protocolInterface=protocolInterface;
	}


	@Override
	public void driver(URL url) {
		System.out.println("MyCar.driver");
		protocolInterface.start(url);
	}
}
