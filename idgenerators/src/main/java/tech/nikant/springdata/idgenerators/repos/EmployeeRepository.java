package tech.nikant.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.idgenerators.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
