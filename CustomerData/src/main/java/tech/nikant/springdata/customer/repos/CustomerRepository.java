package tech.nikant.springdata.customer.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
