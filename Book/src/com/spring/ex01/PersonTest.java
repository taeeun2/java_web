package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));//后 积己
		PersonService person = (PersonService) factory.getBean("personService");//id啊 personService牢 后 啊廉咳
		// PersonService person = new PersonServiceImpl();
		person.sayHello();//积己等 后 捞侩秦 name蔼 龋免
	}
}
