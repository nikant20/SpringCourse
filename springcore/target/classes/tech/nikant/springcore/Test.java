package tech.nikant.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tech.nikant.springcore.list.Hospital;

public class Test {

	public static void main(String[] args) {
		/*
		 * ClassPathXmlApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("config.xml"); Employee emp = (Employee)
		 * applicationContext.getBean("emp");
		 * System.out.println("Employee id:- "+emp.getId()+" "+"Employee Name:- "+emp.
		 * getName());
		 */
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tech/nikant/springcore/list/listconfig.xml");
		Hospital hospital = (Hospital) ctx.getBean("hospital");
		System.out.println("Hospital Name:- "+hospital.getName());
		for (String departMent : hospital.getDepartments()) {
			System.out.println("DepartMent Name:- "+ departMent);
		}
	}

}
