package tech.nikant.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import tech.nikant.springdata.product.entities.Product;
import tech.nikant.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductDataApplicationTests {

	@Autowired
	ProductRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(103);
		product.setName("Samsung Galaxy");
		product.setDescription("Nice");
		product.setPrice(100d);

		repository.save(product);
	}

	@Test
	public void testRead() {
		Optional<Product> findById = repository.findById(101);
		if (findById.isPresent()) {
			Product product = findById.get();
			assertNotNull(product);
			assertEquals("OnePlus", product.getName());
		}
	}

	@Test
	public void testUpdate() {
		Optional<Product> optional = repository.findById(1);

		if (optional.isPresent()) {
			Product product = optional.get();
			product.setName("OnePlus 7t");
			product.setDescription("Awesome");
			repository.save(product);
		}
	}

	@Test
	public void testDelete() {
		if (repository.existsById(101)) {
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
		List<Product> product = repository.findByNameAndDescription("OnePlus", "From OnuPlus");
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
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		Pageable pageable = PageRequest.of(0, 2);
		List<Product> product = repository.findByIdIn(ids, pageable);
		assertNotNull(product);
		product.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void test_findAllPaging() {
		Pageable pageable = PageRequest.of(1, 2);
		Page<Product> results = repository.findAll(pageable);
		assertNotNull(results);
		results.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void test_findAllSorting() {
		repository.findAll(Sort.by(Direction.ASC, "price", "name")).forEach(p -> System.out.println(p.getName()));
		repository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"), new Sort.Order(Direction.DESC, "price")));
	}

	@Test
	public void test_findAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "name");
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}

	@Test
	@Transactional
	public void testCache() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repository.findById(101).get();
		repository.findById(101).get();
		session.evict(product);
		repository.findById(101).get();
	}
}
