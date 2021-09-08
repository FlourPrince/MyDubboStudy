package com.dubbo.register;

import com.dubbo.framework.Url;

import java.util.*;

/**
 * @author pansw
 */
public class RemoteRegister {

	private static Map<String, List<Url>> map = new HashMap();

	public static void register(String interFaceName, Url url) {
		List<Url> list = Collections.singletonList(url);
		map.put(interFaceName, list);
	}


	public static Url random(String interFaceName){
		List<Url> list =map.get(interFaceName);
		Random random=new Random();

		int n=random.nextInt(list.size());

		return  list.get(n);

	}

}
