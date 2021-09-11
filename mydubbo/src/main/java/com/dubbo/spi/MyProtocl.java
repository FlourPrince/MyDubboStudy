package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.extension.Adaptive;

@Activate(value = "activate")
// @Adaptive 优先级最高
public class MyProtocl implements ProtocolInterface {

  @Override
  public void start(URL url) {
    System.out.println("MyProtocl.start");
  }
}
