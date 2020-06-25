package tech.nikant.springdata.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tech.nikant.springdata.customer.entities.Address;
import tech.nikant.springdata.customer.entities.Customer;
import tech.nikant.springdata.customer.repos.CustomerRepository;

@SpringBootTest
class CustomerDataApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}

	
	//@RepeatedTest(10)
	@Test
	public void test_create() {
		Customer customer = new Customer();
		customer.setEmail("xyz@gmail.com");
		customer.setName("John");
		Address address = new Address();
		
		address.setCity("Banglore");
		address.setCountry("India");
		address.setState("Karnataka");
		address.setStreetaddress("Kodathi Village");
		address.setZipcode("560035");
		
		customer.setAddress(address);

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
		if (repository.existsById(1)) {
			repository.deleteById(1);
		}
	}

	@Test
	public void test_findByEmailAndName() {
		List<Customer> findByEmailAndName = repository.findByEmailAndName("Nikant20@gmail.com", "Nikant");
		assertNotNull(findByEmailAndName);
		findByEmailAndName.forEach(f -> System.out.println(f.getName()));
	}

	@Test
	public void test_findByEmailLike() {
		List<Customer> findByEmailLike = repository.findByEmailLike("%20%");
		assertNotNull(findByEmailLike);
		findByEmailLike.forEach(f -> System.out.println(f.getEmail()));
	}

	@Test
	public void test_findByIdIn() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		List<Customer> customer = repository.findByIdIn(ids);
		assertNotNull(customer);
		customer.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test_UpdateEmailOfCustomerById() {
		repository.UpdateEmailOfCustomerById(3, "Nishant21@gmail.com");
	}
	
	@Test
	public void test_findAllUsingPageable() {
		repository.findAllNamesUsingPageable(PageRequest.of(0, 2)).forEach(c->System.out.println(c.getName()));
		repository.findAllNamesUsingPageable(PageRequest.of(0, 5, Direction.DESC,"name")).forEach(c->System.out.println(c.getName()));
	}
	
}
