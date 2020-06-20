package tech.nikant.springdata.hibernateinheritance.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//@DiscriminatorValue("ch")
@Entity
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment{

	private String checknumber;

	public String getCheckNumber() {
		return checknumber;
	}

	public void setCheckNumber(String checknumber) {
		this.checknumber = checknumber;
	}
}
