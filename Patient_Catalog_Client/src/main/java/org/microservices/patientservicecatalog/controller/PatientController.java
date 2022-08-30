package org.microservices.patientservicecatalog.controller;



import org.microservices.patientservicecatalog.VO.DoctorPatient;
import org.microservices.patientservicecatalog.entity.Patient;
import org.microservices.patientservicecatalog.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	
	
	@GetMapping("/patient/on/{id}")
    public DoctorPatient getDoctorPatient(@PathVariable int id){
    	
    	return patientService.getDoctorPatient(id);
    	
    }
	

}
