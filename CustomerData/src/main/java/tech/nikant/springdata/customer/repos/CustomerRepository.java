package tech.nikant.springdata.customer.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tech.nikant.springdata.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByEmailAndName(String email, String name);
	List<Customer> findByEmailLike(String email);
	List<Customer> findByIdIn(List<Integer> ids);
	
	@Modifying
	@Query("update Customer c set c.email=:email where c.id=:id")
	int UpdateEmailOfCustomerById(@Param("id") Integer id, @Param("email") String email);
	
	@Query("from Customer")
	List<Customer> findAllNamesUsingPageable(Pageable pageable);
}
