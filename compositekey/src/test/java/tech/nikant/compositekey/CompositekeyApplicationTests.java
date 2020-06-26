package tech.nikant.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.compositekey.entities.Customer;
import tech.nikant.compositekey.entities.CustomerId;
import tech.nikant.compositekey.repos.CustomerRepository;

@SpringBootTest
class CompositekeyApplicationTests {

	@Autowired
	CustomerRepository repo;
	
	@Test
	public void test_SaveCustomer() {
		Customer customer = new Customer();
		CustomerId customerId = new CustomerId();
		customerId.setId(456);
		customerId.setEmail("abc@email.com");
		customer.setId(customerId);
		customer.setName("Customer");
		repo.save(customer);
	}

}
