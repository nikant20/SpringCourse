package tech.nikant.compositekey.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.nikant.compositekey.entities.Customer;
import tech.nikant.compositekey.entities.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {

}
