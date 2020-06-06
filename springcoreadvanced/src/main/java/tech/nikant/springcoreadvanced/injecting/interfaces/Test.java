package tech.nikant.springcoreadvanced.injecting.interfaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tech/nikant/springcoreadvanced/injecting/interfaces/config.xml");
		OrderBO bo = (OrderBO) applicationContext.getBean("orderBOImpl");
		bo.placeOrder();
	}
}
