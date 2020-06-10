package tech.nikant.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.nikant.springmvc.dto.Employee;

@Controller
public class ObjectController {

	@RequestMapping("/readObject")
	public ModelAndView sendObject() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayObject");

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Prabhudeep");
		employee.setSalary(1000000);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

}
