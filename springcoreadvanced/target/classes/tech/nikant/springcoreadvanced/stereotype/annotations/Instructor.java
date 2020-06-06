package tech.nikant.springcoreadvanced.stereotype.annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("instructor")
@Scope("prototype")
public class Instructor {

	//This is way to invoke a static Method in SpEL
	//@Value("#{T(java.lang.Math).abs(-99)}")
	
	//The way to create a Object
	//@Value("#{new Integer(10)}")
	
	//Static & Final field
	@Value("#{T(java.lang.Integer).MIN_VALUE}")
	private int id;

	
	// Ways to process String in SpEL
	//@Value("#{'Nikant'.toUpperCase()}")
	//@Value("#{new java.lang.String('NIKANT').toLowerCase()}")
	@Value("#{new tech.nikant.springcoreadvanced.stereotype.annotations.Profile().test_method()}")
	private String name;
	
	//Way to Process Boolean SpEL
	@Value("#{2+4>8?true:false}")
	private Boolean active;

	@Value("#{topics}")
	private List<String> topics;
	
	@Autowired
	private Profile profile;

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

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", active=" + active + ", topics=" + topics + ", profile="
				+ profile + "]";
	}

	
	

}
