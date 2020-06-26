package tech.nikant.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
