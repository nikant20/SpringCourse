package tech.nikant.springdata.patientscheduling;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.patientscheduling.entities.Appointment;
import tech.nikant.springdata.patientscheduling.entities.Doctor;
import tech.nikant.springdata.patientscheduling.entities.Insurance;
import tech.nikant.springdata.patientscheduling.entities.Patient;
import tech.nikant.springdata.patientscheduling.repos.AppointmentRepository;
import tech.nikant.springdata.patientscheduling.repos.DoctorRepository;
import tech.nikant.springdata.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientschedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	public void test_createDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Nikant");
		doctor.setLastName("Chaudhary");
		doctor.setSpeciality("General Physician");
		doctorRepository.save(doctor);
	}

	@Test
	public void test_createPatient() {
		Patient patient = new Patient();
		patient.setFirstName("Prabhudeep");
		patient.setLastName("Singh");
		patient.setPhone("123456");
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Star Insurance");
		insurance.setCopay(100d);
		
		patient.setInsurance(insurance);
		
		Doctor doctor = doctorRepository.findById(1L).get();
		List<Doctor> doctorList = Arrays.asList(doctor);
		
		patient.setDoctors(doctorList);

		patientRepository.save(patient);
	}
	
	@Test
	public void test_createAppointment() {
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime );
		appointment.setReason("Coughing");
		appointment.setStarted(true);
		Patient patient = patientRepository.findById(1L).get();
		appointment.setPatient(patient);
		Doctor doctor = doctorRepository.findById(1L).get();
		appointment.setDoctor(doctor);
		appointmentRepository.save(appointment);
	}

}
