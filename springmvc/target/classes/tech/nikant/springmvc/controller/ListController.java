package tech.nikant.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.nikant.springmvc.dto.Employee;

@Controller
public class ListController {

	@RequestMapping("/readList")
	public ModelAndView sendList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayList");

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Prabhudeep");
		employee.setSalary(1000000);

		Employee employee2 = new Employee();
		employee2.setId(102);
		employee2.setName("Amulya");
		employee2.setSalary(1000000);

		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		list.add(employee2);

		modelAndView.addObject("employeeList", list);
		return modelAndView;
	}

}
