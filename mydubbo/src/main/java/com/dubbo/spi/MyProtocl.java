package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;

@Activate(value = "activate")
public class MyProtocl implements ProtocolInterface {

  @Override
  public void start(URL url) {
    System.out.println("MyProtocl.start");
  }
}
