package tech.nikant.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {

	@Autowired
	Dao dao;
	
	public void init() {
		System.out.println("init()");
	}
	
	public void save() {
		dao.Create();
	}
	
	
	public void destroy() {
		System.out.println("destroy()");
	}
}
