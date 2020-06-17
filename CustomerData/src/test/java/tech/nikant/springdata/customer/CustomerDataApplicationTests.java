package tech.nikant.springdata.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.customer.entities.Customer;
import tech.nikant.springdata.customer.repos.CustomerRepository;

@SpringBootTest
class CustomerDataApplicationTests {

	@Autowired
	CustomerRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void test_create() {
		Customer customer = new Customer();
		customer.setEmail("xyz@gmail.com");
		customer.setName("John");
		
		repository.save(customer);
	}
	
	@Test
	public void test_read() {
		Customer customer = repository.findById(1).get();
		assertNotNull(customer);
		assertEquals("John", customer.getName());
	}
	
	@Test
	public void test_update() {
		Customer customer = repository.findById(1).get();
		customer.setEmail("abc@gmail.com");
		
		repository.save(customer);
		
		Customer updatedCustomer = repository.findById(1).get();
		assertEquals("abc@gmail.com", updatedCustomer.getEmail());
	}
	
	@Test
	public void test_delete() {
		if(repository.existsById(1)) {
			repository.deleteById(1);
		}
	}

}
