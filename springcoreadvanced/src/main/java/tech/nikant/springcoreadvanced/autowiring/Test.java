package tech.nikant.springcoreadvanced.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		Employee emp = (Employee) applicationContext.getBean("employee");
		System.out.println(emp);

	}
}
