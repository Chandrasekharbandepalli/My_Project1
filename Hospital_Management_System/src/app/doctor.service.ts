import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseURL = "http://localhost:8088/doctors";


  constructor(private httpClient: HttpClient) { }
  
  createDoctor(doctor:Doctor): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, doctor);
  }

 
  getDoctorbyId(id:number):Observable<Doctor>{
    return this.httpClient.get<Doctor>(`${this.baseURL}/get/${id}`)
  }
  
  getAllDoctors(): Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(`${this.baseURL}/`);
  } 

}
