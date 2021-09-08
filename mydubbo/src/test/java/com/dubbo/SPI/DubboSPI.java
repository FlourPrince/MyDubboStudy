package com.dubbo.SPI;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.dubbo.framework.Url;
import com.dubbo.spi.Car;
import com.dubbo.spi.ProtocolInterface;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DubboSPI {

@Test
public void test1(){
	//DubboSPI模式
	//1.在resources目录下创建META-INF.dubbo文件夹
	//2.创建目标接口的全限定类名  文件
	//3.通过键值对存储实现类  dubboProtocol = com.dubbo.protocol.dubbo.DubboProtocol
	//4.目标接口添加@SPI注解
	ExtensionLoader<ProtocolInterface> extensionLoader = ExtensionLoader.getExtensionLoader(ProtocolInterface.class);
	ProtocolInterface protocol = extensionLoader.getExtension("myProtocol");
}

	@Test
public void test2(){
		//1.自动包装  MyProtocolAware 构造器注入ProtocolInterface
		//2.自动装配  MyCar set方法注入ProtocolInterface
		//3.扩展点自适应@Adaptive
		// ProtocolInterface 方法上加@Adaptive 注解  入参传入URL 判定调用哪个实现类
		//4.扩展点自动激活 @Activate
		ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
		Car car = extensionLoader.getExtension("myCar");
		Map<String,String> map=new HashMap();
		map.put("type","myProtocol");
		URL url=new URL( "","",0,map);

		car.driver(url);
}
}
