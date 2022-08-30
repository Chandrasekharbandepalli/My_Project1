package org.microservices.doctorservicecatalog.repository;



import org.microservices.doctorservicecatalog.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	
	@Query(value = "SELECT * FROM doctor d WHERE d.name=?1",nativeQuery = true)
	Doctor getDoctorByName(String docName);

	@Query(value = "SELECT d.name FROM doctor d WHERE d.id=?1", nativeQuery = true)
	String getDoctorName(int id);

}
