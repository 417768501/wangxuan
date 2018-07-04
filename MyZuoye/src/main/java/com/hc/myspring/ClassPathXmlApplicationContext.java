package com.hc.myspring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	Map<String, Object> map = new HashMap<String, Object>();
	public String pathName;//文件名
	
	public ClassPathXmlApplicationContext(String pathName) throws Exception {
		System.out.println("进入ClassPathXmlApplicationContext_ClassPathXmlApplicationContext方法");
		this.pathName = pathName;
		SAXReader reader = new SAXReader();
		Document doc = reader.read(this.getClass().getResourceAsStream("/"+pathName));
		List<Node> list = doc.selectNodes("//bean");
		for(Node node:list){
			String name = node.valueOf("@name");
			String className = node.valueOf("@class");
			System.out.println("name:"+name);
			System.out.println("className:"+className);
			//获取类对象
			Class<?> class1 = Class.forName(className);
			System.out.println("class1类对象:"+class1);
			map.put(name, class1.newInstance());
			
		}
		System.out.println("map:"+map);
	}

	@Override
	public Object getBean(String beanName) {
		System.out.println("进入ClassPathXmlApplicationContext_getBean方法");
		return map.get(beanName);
	}

}
