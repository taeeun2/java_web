package com.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	   public static void main(String[] args){
	      ApplicationContext context=new ClassPathXmlApplicationContext("AOPTest.xml");//后 积己
	      Calculator cal=(Calculator)context.getBean("proxyCal");//proxyCal后俊 立辟

	      cal.add(100,20);
	      System.out.println();
	      cal.subtract(100,20);
	      System.out.println();
	      cal.multiply(100,20);
	      System.out.println();
	      cal.divide(100,20);
	   }
	}

