package tech.nikant.springdata.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer>{

}
