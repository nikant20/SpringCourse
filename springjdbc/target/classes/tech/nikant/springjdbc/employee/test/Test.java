package tech.nikant.springjdbc.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tech.nikant.springjdbc.employee.dao.EmployeeDao;
import tech.nikant.springjdbc.employee.dto.Employee;

public class Test {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tech/nikant/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) applicationContext.getBean("employeeDao");
		/*
		 * Employee employee = new Employee(); employee.setId(2);
		 * employee.setFirstName("Amulya"); employee.setLastName("Garg");
		 */
		//int result = dao.create(employee);
		//int result = dao.update(employee);
		//int result = dao.delete(employee);
		//Employee result = dao.read(1);
		List<Employee> result = dao.read();
		System.out.println("Employee Record:- "+result);
	}
}
