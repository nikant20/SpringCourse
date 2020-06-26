package tech.nikant.mongodb.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.nikant.mongodb.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
