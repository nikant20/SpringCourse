package tech.nikant.springdata.hibernateinheritance.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//@DiscriminatorValue("cc")
@Entity
@Table(name = "card")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment{
	
	private String cardnumber;

	public String getCardNumber() {
		return cardnumber;
	}

	public void setCardNumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

}
