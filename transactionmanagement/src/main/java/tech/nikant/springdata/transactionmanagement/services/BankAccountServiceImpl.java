package tech.nikant.springdata.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.nikant.springdata.transactionmanagement.entities.BankAccount;
import tech.nikant.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount obamasAccount = repository.findById(1).get();
		
		obamasAccount.setBal(obamasAccount.getBal()-amount);
		repository.save(obamasAccount);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount trumpsAccount = repository.findById(2).get();
		trumpsAccount.setBal(trumpsAccount.getBal()+amount);
		repository.save(trumpsAccount);
		
	}

}
