package tech.nikant.springcoreadvanced.injecting.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderBOImpl implements OrderBO {

	@Autowired
	//Use Camel Case to refer to corresponding class
	@Qualifier("orderDAOImpl2")
	private OrderDAO dao;

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	@Override
	public void placeOrder() {
		System.out.println("Inside Order BoImpl");
		dao.createOrder();
	}

}
