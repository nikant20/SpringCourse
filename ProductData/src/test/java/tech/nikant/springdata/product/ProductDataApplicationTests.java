package tech.nikant.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.product.entities.Product;
import tech.nikant.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductDataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(101);
		product.setName("OnePlus");
		product.setDesc("Awesome");
		product.setPrice(1000d);
		
		repository.save(product);
	}
	
	@Test
	public void testRead() {
		Optional<Product> findById = repository.findById(101);
		if(findById.isPresent()) {
			Product product = findById.get();
			assertNotNull(product);
			assertEquals("OnePlus", product.getName());
		}
	}
	
	@Test
	public void testUpdate() {
		Optional<Product> optional  = repository.findById(1);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			product.setName("OnePlus 7t");
			product.setDesc("Awesome");
			repository.save(product);
		} 
	}
	
	@Test
	public void testDelete() {
		if(repository.existsById(101)) {
			repository.deleteById(101);
		}
		
	}

}
