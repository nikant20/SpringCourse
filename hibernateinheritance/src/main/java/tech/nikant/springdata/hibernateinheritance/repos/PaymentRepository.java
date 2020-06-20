package tech.nikant.springdata.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
