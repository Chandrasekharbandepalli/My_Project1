package org.microservices.patientservicecatalog.service;

import org.microservices.patientservicecatalog.VO.DoctorPatient;
import org.microservices.patientservicecatalog.entity.Patient;
import org.microservices.patientservicecatalog.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Patient savePatient(Patient patient) {
		 
		return patientRepository.save(patient);
	}

	

	public DoctorPatient getDoctorPatient(int id) {
		
		Patient pat = patientRepository.findById(id).get();
		String doctor_name = restTemplate.getForObject("http://DOCTOR-SERVICE/doctors/doctorName/"+pat.getVisitedDoctor(), String.class);
		DoctorPatient docp = new DoctorPatient(pat.getId(),pat.getName(),doctor_name,pat.getDateOfVisit(),pat.getPrescription());
		
	
		return docp;
		
		
	}

	

	

}
