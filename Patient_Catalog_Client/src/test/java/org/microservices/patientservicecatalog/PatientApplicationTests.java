package org.microservices.patientservicecatalog;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import org.microservices.patientservicecatalog.entity.Patient;
import org.microservices.patientservicecatalog.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PatientApplicationTests {
        
	    @Autowired
		private PatientRepository patientRepo;
		
	    @Test
		public void savePatientTest() {
	    	Patient pat = new Patient();
	    	pat.setId(1);
			pat.setName("Ravadev");
			pat.setVisitedDoctor(1);
			pat.setDateOfVisit("20/08/2022");
			pat.setPrescription("Heart Issue");
			patientRepo.save(pat);
			assertNotNull(patientRepo.findById(1).get());
		}
	    @Test
		public void getPatientByIdTest() {
			Patient patient = patientRepo.findById(1).get();
			assertEquals("Ravadev", patient.getName());
		}
		}

	