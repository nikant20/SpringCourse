package tech.nikant.springcoreadvanced.injecting.interfaces;

import org.springframework.stereotype.Component;

@Component
public class OrderDAOImpl2 implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside Order DAO Impl2 create Order");
	}

}
