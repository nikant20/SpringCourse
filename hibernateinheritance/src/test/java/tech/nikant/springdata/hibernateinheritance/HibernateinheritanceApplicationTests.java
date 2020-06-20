package tech.nikant.springdata.hibernateinheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.hibernateinheritance.entities.Check;
import tech.nikant.springdata.hibernateinheritance.entities.CreditCard;
import tech.nikant.springdata.hibernateinheritance.repos.PaymentRepository;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(10000);
		cc.setCardNumber("123456789");
		repository.save(cc);
	}
	
	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(10000);
		ch.setCheckNumber("1234567");
		repository.save(ch);
	}

}
