package tech.nikant.springcoreadvanced.stereotype.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tech/nikant/springcoreadvanced/stereotype/annotations/config.xml");
		Instructor emp = (Instructor) applicationContext.getBean("instructor");
		System.out.println(emp);
	}
}
