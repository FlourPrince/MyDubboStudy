package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.dubbo.framework.Invocation;
import com.dubbo.framework.Protocol;
import com.dubbo.framework.Url;

@Activate(value = "activate1")
public class MyProtocl1 implements ProtocolInterface {

  @Override
  public void start(URL url) {
    System.out.println("MyProtocl1.start");
  }
}
