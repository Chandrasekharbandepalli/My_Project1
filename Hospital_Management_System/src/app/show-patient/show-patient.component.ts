import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {

  patients:any;
  message:any;
  patientId:any;
 


  constructor(private service:PatientService,private router:Router) { }

   errormessage:String;
   public getPatientDetails(patientId:number){
    
    let response= this.service.getPatient(patientId);
    response.subscribe({next:(data)=>this.patients=data, 
    error:(error)=>{console.log(error);this.errormessage=error.error}});
  
    console.log("data--",this.patients)
   
   }

  ngOnInit(): void {

     
  }
  back():void{
    this.router.navigate(['']);
  }

  private handleError(error: HttpErrorResponse) {
    let errorresponse='';
    if (error.status === 0) {
      errorresponse = error.error;
      console.error('An error occurred:', error.error);
    } else {
      errorresponse = error.error;
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    
    return throwError(() => new Error(errorresponse));
  }

}
