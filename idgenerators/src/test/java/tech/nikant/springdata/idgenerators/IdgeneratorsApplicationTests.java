package tech.nikant.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository er;
	
	@Test
	void test_create_repository() {
		Employee employee = new Employee();
		employee.setName("John");
		er.save(employee );
	}

}
