package tech.nikant.springdata.associations.onetomany.entities;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
