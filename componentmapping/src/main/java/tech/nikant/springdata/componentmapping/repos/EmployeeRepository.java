package tech.nikant.springdata.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
