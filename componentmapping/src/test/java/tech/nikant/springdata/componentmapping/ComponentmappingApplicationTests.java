package tech.nikant.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.componentmapping.entities.Address;
import tech.nikant.springdata.componentmapping.entities.Employee;
import tech.nikant.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void test_create() {
		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Nikant");
		
		Address address = new Address();
		address.setCity("Banglore");
		address.setCountry("India");
		address.setState("Karnataka");
		address.setStreetaddress("Kodathi Village");
		address.setZipcode("560035");
		
		employee.setAddress(address);
		
		repository.save(employee);
	}

}
