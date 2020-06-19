package tech.nikant.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tech.nikant.springdata.jpqlandnativesql.entities.Student;
import tech.nikant.springdata.jpqlandnativesql.entities.repos.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void test_studentCreation() {
		Student student = new Student();
		student.setFirstName("Nikant");
		student.setLastName("Chaudhary");
		student.setScore(99);

		repository.save(student);

		Student student2 = new Student();
		student2.setFirstName("Bill");
		student2.setLastName("Gates");
		student2.setScore(75);

		repository.save(student2);
	}

	@Test
	public void test_findAllStudent() {
		repository.findAll(PageRequest.of(1, 5, Direction.DESC,"id")).forEach(s -> System.out.println(s));
	}

	@Test
	public void test_findAllStudentsPartialData() {
		List<Object[]> findAllStudentsPartialData = repository.findAllStudentsPartialData();
		for (Object[] objects : findAllStudentsPartialData) {
			System.out.print(objects[0]+" ");
			System.out.println(objects[1]);
		}
	}
	
	@Test
	public void test_findByFirstName() {
		repository.findByFirstName("Nikant").forEach(s->System.out.println(s.getFirstName()));
	}

	@Test
	public void test_findAllStudentByScores() {
		repository.findByScore(75, 99).forEach(s->System.out.println(s));
	}
	
	@Test
	@Transactional //Need this as this operation is DML operation
	@Rollback(false) //it tells our spring runner to not to roll back transaction after Junit is executed
 	public void test_deleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("Bill");
	}
	
	@Test
	public void test_findAllStudentsUsingNativeQuery() {
		repository.findAllStudentsUsingNativeQuery().forEach(s->System.out.println(s));
	}
	
	@Test
	public void test_findByFirstNameUsingNativeQuery() {
		repository.findByFirstNameUsingNativeQuery("Nikant").forEach(s->System.out.println(s));
	}
	
}
