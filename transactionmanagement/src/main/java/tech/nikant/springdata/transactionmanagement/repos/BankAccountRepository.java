package tech.nikant.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
