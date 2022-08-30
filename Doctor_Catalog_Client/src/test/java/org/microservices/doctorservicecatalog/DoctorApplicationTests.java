package org.microservices.doctorservicecatalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.microservices.doctorservicecatalog.entity.Doctor;
import org.microservices.doctorservicecatalog.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoctorApplicationTests {
	
	   
		@Autowired
		private DoctorRepository doctorRepo;
		
		
		@Test
		public void saveDoctorTest() {
			Doctor dc = new Doctor();
			dc.setId(1);
			dc.setName("Anu");
			dc.setGender("Female");
			dc.setSpecialist("Gastro");
			dc.setAge(45);
			doctorRepo.save(dc);
			assertNotNull(doctorRepo.findById(1).get());
		}
		
		@Test
		public void getDoctorByIdTest() {
			Doctor doctor = doctorRepo.findById(1).get();
			assertEquals(45, doctor.getAge());
		}

		
		
}