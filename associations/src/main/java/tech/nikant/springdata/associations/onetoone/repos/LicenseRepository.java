package tech.nikant.springdata.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
