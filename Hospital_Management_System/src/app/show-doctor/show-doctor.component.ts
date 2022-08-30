import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-show-doctor',
  templateUrl: './show-doctor.component.html',
  styleUrls: ['./show-doctor.component.css']
})
export class ShowDoctorComponent implements OnInit {

  doci:any;
  doctors:any;
  doctemp:boolean=false;
  message:any;
  doctId:any;
  


  constructor(private service:DoctorService,private router:Router) { }


   selectName(pid :number){
    this.doctemp=true;

  
    let response= this.service.getDoctorbyId(pid);
    response.subscribe((data)=>this.doci=data);

  
    
    console.log("id--->",pid);
    console.log("doctors--->",this.doci.docName);
    
   }

   
  


  ngOnInit(): void {
    let response = this.service.getAllDoctors();
    response.subscribe((data)=>this.doctors=data);
  }
  back():void{
    this.router.navigate(['']);
  }


  


}
