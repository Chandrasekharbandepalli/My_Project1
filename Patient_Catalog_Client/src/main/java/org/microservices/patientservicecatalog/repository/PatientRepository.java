package org.microservices.patientservicecatalog.repository;

import org.microservices.patientservicecatalog.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query(value = "SELECT Count(p.id) as total_patient FROM patient p WHERE p.visited_doctor=?1",nativeQuery = true)
	int countTotal(String docName);

}
