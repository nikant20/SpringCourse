package tech.nikant.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.nikant.springmvc.dto.User;

@Controller
public class UserController {

	/*
	 * Since, ModelAndView Api by spring is highyly coupled as you need to create a ModelAndView object
	 * even when it is not needed. 
	 * 
	 * Later, spring introduced two seperate APIs to hadle this, namely ModelMap and String.
	 * now, return name of jsp file as String and Spring will map the name of jsp file automatically.
	 * 
	 * */
	
	/*
	 * @RequestMapping("registrationPage") public ModelAndView
	 * showRegistrationPage() { ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("userReg"); return modelAndView; }
	 */

	//Migrating above Code
	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}
	
	/*
	 * Use @ModelAttribute to map from JSP name values to Java POJOs. This will map
	 * values of "name="id" name="name" and name="email" " from jsp to User class in
	 * Java.
	 * 
	 * @ModelAttribute will do this Mapping.
	 */
	/*
	 * @RequestMapping(value = "registerUser", method = RequestMethod.POST) public
	 * ModelAndView registerUser(@ModelAttribute("user") User user) {
	 * System.out.println(user); ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.addObject("user", user); modelAndView.setViewName("regResult");
	 * return modelAndView; }
	 */
	
	//Migrating Above Code
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("user", user);
		return "regResult";
	}
	

}
