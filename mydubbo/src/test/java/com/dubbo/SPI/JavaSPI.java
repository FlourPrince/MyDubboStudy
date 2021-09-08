package com.dubbo.SPI;






import com.dubbo.framework.Protocol;

import java.util.Iterator;
import java.util.ServiceLoader;

public class JavaSPI {
		public static void main(String[] args) {
		//java spi模式
		//1.在resources目录下创建META-INF.services文件夹
		//2.创建目标接口的全限定类名  文件
		//3.添加接口实现类全限定类名  内容
		ServiceLoader<Protocol> serviceLoader=ServiceLoader.load(Protocol.class);
		Iterator<Protocol> iterator= serviceLoader.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());;
		}
	}
}
