package tech.nikant.springdata.idgenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

	
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	//@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GenericGenerator(name="emp_id",strategy = "tech.nikant.springdata.idgenerators.CustomRandomIdGenerator")
	@GeneratedValue(generator = "emp_id")
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
