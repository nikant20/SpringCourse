package tech.nikant.springjdbc.employee.dao;

import java.util.List;

import tech.nikant.springjdbc.employee.dto.Employee;

public interface EmployeeDao {
	int create(Employee employee);
	
	int update(Employee employee);
	
	int delete(Employee employee);
	
	Employee read(int id);
	
	List<Employee> read();
}
