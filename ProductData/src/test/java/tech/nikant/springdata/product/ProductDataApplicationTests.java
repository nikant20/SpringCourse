package tech.nikant.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
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
		product.setDescription("Awesome");
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
			product.setDescription("Awesome");
			repository.save(product);
		} 
	}
	
	@Test
	public void testDelete() {
		if(repository.existsById(101)) {
			repository.deleteById(101);
		}
		
	}
	
	@Test
	public void test_findByName() {
		List<Product> product = repository.findByName("OnePlus");
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void test_findByNameAndDesc() {
		List<Product> product = repository.findByNameAndDescription("OnePlus","From OnuPlus");
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void test_findByPriceGraterThan() {
		List<Product> product = repository.findByPriceGreaterThanEqual(1d);
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void test_findByPriceBetween() {
		List<Product> product = repository.findByPriceBetween(1d, 100d);
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void test_findByNameContains() {
		List<Product> product = repository.findByDescriptionLike("From%");
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void test_findByIdIn() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		List<Product> product = repository.findByIdIn(ids);
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}
}
