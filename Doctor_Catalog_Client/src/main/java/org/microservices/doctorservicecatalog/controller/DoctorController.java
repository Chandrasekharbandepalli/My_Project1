package org.microservices.doctorservicecatalog.controller;

import java.util.List;

import org.microservices.doctorservicecatalog.entity.Doctor;
import org.microservices.doctorservicecatalog.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctors")
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@GetMapping("/doctors/")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctors/doctorName/{id}")
	public String getDoctorName(@PathVariable int id) {
		
		return doctorService.getDoctorByName(id);
	}
	   

	@GetMapping("/doctors/get/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}
	
	

}
