import { Component,OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  patient:Patient = new Patient();
 
  message:any;
  doctors:any;
  doctorinfo:any;


  constructor(private patService:PatientService,private service:DoctorService,private router:Router) { }

  ngOnInit(): void {

    let response = this.service.getAllDoctors();
    response.subscribe((data)=>this.doctors=data);
  }

  public patientRegistration(){
   let response = this.patService.createPatient(this.patient);
    response.subscribe((data)=>this.message=data);
    this.router.navigate(['']);
    

  }
 

}
