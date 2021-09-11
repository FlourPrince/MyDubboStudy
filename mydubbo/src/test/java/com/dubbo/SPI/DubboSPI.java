package com.dubbo.SPI;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.dubbo.framework.Protocol;
import com.dubbo.spi.ProtocolInterface;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DubboSPI {

  @Test
  public void test1() {
    // DubboSPI模式
    // 1.在resources目录下创建META-INF.dubbo文件夹
    // 2.创建目标接口的全限定类名  文件
    // 3.通过键值对存储实现类  dubboProtocol = com.dubbo.protocol.dubbo.DubboProtocol
    // 4.目标接口添加@SPI注解
    ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
    Protocol protocol = extensionLoader.getExtension("dubboProtocol");
  }

  @Test
  public void test2() {
    // DubboSPI模式    自动装配
    // 1.在resources目录下创建META-INF.dubbo文件夹
    // 2.创建目标接口的全限定类名  文件
    // 3.通过键值对存储实现类  myProtocol =com.dubbo.spi.MyProtocol  com.dubbo.spi.MyProtocolAware
    // 4.目标接口添加@SPI注解
    ExtensionLoader<ProtocolInterface> extensionLoader =
        ExtensionLoader.getExtensionLoader(ProtocolInterface.class);
    ProtocolInterface protocol = extensionLoader.getExtension("myProtocol");
  }

  @Test
  public void test3() {
    // DubboSPI模式   @Adaptive  动态运行实现类
    // 1.在resources目录下创建META-INF.dubbo文件夹
    // 2.创建目标接口的全限定类名  文件
    // 3.通过键值对存储实现类  myProtocol = com.dubbo.spi.MyProtocl  //myProtocol1 = com.dubbo.spi.MyProtocl1
    // 4.@SPI("myProtocol") 默认
    // 5.@Adaptive("type") 通过URL 传值进入    @Adaptive@在实现类上
    ExtensionLoader<ProtocolInterface> extensionLoader =
        ExtensionLoader.getExtensionLoader(ProtocolInterface.class);
    ProtocolInterface protocolInterface = extensionLoader.getAdaptiveExtension();
    Map<String, String> map = new HashMap();
    map.put("type", "myProtocol");
    URL url = new URL("", "", 0, map);
    protocolInterface.start(url);
  }

  @Test
  public void test4() {
    // DubboSPI模式   @Activate   标识这个扩展实现激活的条件和时机
    // 1.在resources目录下创建META-INF.dubbo文件夹
    // 2.创建目标接口的全限定类名  文件
    // 3.通过键值对存储实现类  myProtocol = com.dubbo.spi.MyProtocl  //myProtocol1 = com.dubbo.spi.MyProtocl1
    // 4.@SPI
    // 5.@Activate(value = "activate")  实现类激活条件
    // 6. url参数包含activate
    // 提供四种获取方法
    // getActivateExtension(URL url, String key)
    // getActivateExtension(URL url, String[] values)   values 实现类名称集合
    // getActivateExtension(URL url, String key, String group)
    // getActivateExtension(URL url, String[] values, String group)
    ExtensionLoader<ProtocolInterface> extensionLoader =
        ExtensionLoader.getExtensionLoader(ProtocolInterface.class);
    Map<String, String> map = new HashMap();
    map.put("activate", "1");
    URL url = new URL("", "", 0, map);
    String[] values = new String[1];
    values[0] = "myProtocol";

    List<ProtocolInterface> list = extensionLoader.getActivateExtension(url, values);
    for (ProtocolInterface protocolInterface : list) {
      protocolInterface.start(url);
    }
  }
}
