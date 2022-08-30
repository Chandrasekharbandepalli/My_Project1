package org.microservices.doctorservicecatalog.service;

import java.util.List;

import org.microservices.doctorservicecatalog.entity.Doctor;
import org.microservices.doctorservicecatalog.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	
	public List<Doctor> getAllDoctors() {
		
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(int id) {
		
		return doctorRepository.findById(id).get();
	}

	public String getDoctorByName(int id) {
		
		return doctorRepository.getDoctorName(id);
	}

}
