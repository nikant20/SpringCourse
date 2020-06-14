package tech.nikant.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.nikant.springboot.dao.Dao;

@Component
public class Service {

	@Autowired
	Dao dao;
	
	public void save() {
		dao.create();
	}
	
}
