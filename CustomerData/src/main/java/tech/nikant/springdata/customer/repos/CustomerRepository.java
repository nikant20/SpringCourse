package tech.nikant.springdata.customer.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByEmailAndName(String email, String name);
	List<Customer> findByEmailLike(String email);
	List<Customer> findByIdIn(List<Integer> ids);
}
