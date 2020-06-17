package tech.nikant.springdata.product.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.nikant.springdata.product.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
		List<Product> findByName(String name);
		
		List<Product> findByNameAndDescription(String name, String description);
		
		List<Product> findByPriceGreaterThanEqual(Double price);
		
		List<Product> findByDescriptionLike(String description);
		
		List<Product> findByPriceBetween(Double price1, Double price2);
		
		List<Product> findByIdIn(List<Integer> ids);
}
