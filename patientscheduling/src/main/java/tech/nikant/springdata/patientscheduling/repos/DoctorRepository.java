package tech.nikant.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
