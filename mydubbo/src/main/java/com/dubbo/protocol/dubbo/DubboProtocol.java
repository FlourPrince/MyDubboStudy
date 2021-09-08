package com.dubbo.protocol.dubbo;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.dubbo.framework.Invocation;
import com.dubbo.framework.Protocol;
import com.dubbo.framework.Url;

/**
 * @author pansw
 */
public class DubboProtocol implements Protocol {
	@Override
	public void start(Url url) {

	}

	@Override
	public String send(Url url, Invocation invocation) {
		return null;
	}
}
