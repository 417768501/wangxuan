package com.hc.myspring;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hc.bean.Person;
import com.hc.bean.Worker;

public class ApplicationContextTest {

	@Test
	public void testGetBean() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		person.eat();
		
		Worker worker = (Worker) applicationContext.getBean("worker");
		worker.work();
	}

}
