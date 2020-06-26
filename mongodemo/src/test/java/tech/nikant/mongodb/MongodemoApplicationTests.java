package tech.nikant.mongodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.mongodb.model.Product;
import tech.nikant.mongodb.repos.ProductRepository;

@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Test
	public void test_Save() {
		Product product = new Product();
		product.setName("MacBook Pro");
		product.setPrice(2000);
		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
	}
	
	@Test
	public void test_findAll() {
		List<Product> products = repository.findAll();
		products.forEach(p -> System.out.println(p.getName()));
		assertEquals(1, products.size());
	}
	
	@Test
	public void test_delete() {
		repository.deleteById("5ef55e3f07b13455f585320c");
		Optional<Product> product = repository.findById("5ef55e3f07b13455f585320c");
		assertEquals(Optional.empty(), product);
	}
	
	@Test
	public void test_update() {
		Product product = repository.findById("5ef5600ffad4201c620858a9").get();
		product.setName("Windows");
		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
	}
	
}
