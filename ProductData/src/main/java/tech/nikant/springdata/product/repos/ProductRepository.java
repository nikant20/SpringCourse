package tech.nikant.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.nikant.springdata.product.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
