package com.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("myProtocol")
public interface ProtocolInterface {

  @Adaptive("type")
  void start(URL url);
}
