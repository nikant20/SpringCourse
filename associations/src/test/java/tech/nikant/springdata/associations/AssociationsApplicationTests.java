package tech.nikant.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tech.nikant.springdata.associations.manytomany.entities.Programmer;
import tech.nikant.springdata.associations.manytomany.entities.Project;
import tech.nikant.springdata.associations.manytomany.repos.ProgrammerRepository;
import tech.nikant.springdata.associations.onetomany.entities.Customer;
import tech.nikant.springdata.associations.onetomany.entities.CustomerRepository;
import tech.nikant.springdata.associations.onetomany.entities.PhoneNumber;
import tech.nikant.springdata.associations.onetoone.entities.License;
import tech.nikant.springdata.associations.onetoone.entities.Person;
import tech.nikant.springdata.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository; 

	@Test
	void contextLoads() {
	}

	@Test
	public void test_createCustomer() {
		Customer customer = new Customer();
		customer.setName("Nikant");

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Office");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("Home");

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}

	@Test
	public void test_loadCustomer() {
		Customer customer = repository.findById(4L).get();
		System.out.println(customer.getName());
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(c -> System.out.println(c.getNumber()));
	}

	@Test
	@Transactional //this is needed for lazy loading to work
	public void test_updateCustomer() {
		Customer customer = repository.findById(4L).get();
		customer.setName("Nikant Chaudhary");
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(c -> c.setType("Cell"));
		
		repository.save(customer);
	}
	
	@Test
	public void test_delete() {
		repository.deleteById(4L);
	}
	
	@Test
	public void test_manyToMany_createProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Nikant");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		
		Project project = new Project();
		project.setName("JPA Project");
		
		projects.add(project);
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
	}
	
	@Test
	@Transactional
	public void test_manyToMany_findProgrammer() {
		Programmer programmer = programmerRepository.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
	
	@Test
	public void test_oneToOneCreateLicense() {
		License license = new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Nikant");
		person.setLastName("Chaudhary");
		person.setAge(27);
		
		license.setPerson(person);
		licenseRepository.save(license);
	}

}
