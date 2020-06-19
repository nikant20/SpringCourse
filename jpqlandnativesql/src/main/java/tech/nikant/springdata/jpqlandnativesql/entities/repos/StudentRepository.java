package tech.nikant.springdata.jpqlandnativesql.entities.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.nikant.springdata.jpqlandnativesql.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	//Example Of Pagination and Sorting
	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query("select st.firstName, st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName=:firstName")
	List<Student> findByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score>=:min and score<=:max")
	List<Student> findByScore(@Param("min") int min, @Param("max") int max);
	
	//Need @Modifying Annotation as it isn't read operation instead it is an DML operation. For read operation we don't 
	//need @Modifying annotation.
	@Modifying
	@Query("delete from Student where firstName=:firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);
	
	
	//Way to run Native SQL Query
	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentsUsingNativeQuery();
	
	@Query(value = "select * from student where fname=:firstName", nativeQuery = true)
	List<Student> findByFirstNameUsingNativeQuery(@Param("firstName") String firstName);
	
	
	
}
