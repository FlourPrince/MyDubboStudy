package com.dubbo.framework;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author pansw
 */
@SPI
public interface Protocol {

	@Adaptive
	void start(Url url);

	String send(Url url,Invocation invocation);
}
