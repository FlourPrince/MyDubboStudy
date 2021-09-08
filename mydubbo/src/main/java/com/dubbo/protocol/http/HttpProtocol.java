package com.dubbo.protocol.http;

import com.dubbo.framework.Invocation;
import com.dubbo.framework.Protocol;
import com.dubbo.framework.Url;


/**
 * @author pansw
 */
public class HttpProtocol implements Protocol {

	@Override
	public void start(Url url) {
		HttpServer httpServer=new HttpServer();
		httpServer.start(url.getHostName(),url.getPort());
	}

	@Override
	public String send(Url url, Invocation invocation) {
		HttpClient httpClient=new HttpClient();
		return httpClient.send(url.getHostName(),url.getPort(),invocation);
	}
}
