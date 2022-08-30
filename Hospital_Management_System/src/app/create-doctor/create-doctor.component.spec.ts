import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDoctorComponent } from './create-doctor.component';
import {Component, DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";
describe('CreateDoctorComponent', () => {
  let component: CreateDoctorComponent;
  let fixture: ComponentFixture<CreateDoctorComponent>;
  let submitEl: DebugElement;
  let nameEl : DebugElement;
  let ageEl : DebugElement;
  let genderEl: DebugElement;
  let specialistEl: DebugElement;
  let patientsattendedEl: DebugElement;

  beforeEach(async () => {
     TestBed.configureTestingModule({
      declarations: [ CreateDoctorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateDoctorComponent);
    component = fixture.componentInstance;
    submitEl = fixture.debugElement.query(By.css('button'));
    nameEl = fixture.debugElement.query(By.css('input[type=text]'));
    ageEl = fixture.debugElement.query(By.css('input[type=number]'));
    genderEl = fixture.debugElement.query(By.css('input[type=radio]'));
    specialistEl = fixture.debugElement.query(By.css('input[type=text]'));
    patientsattendedEl = fixture.debugElement.query(By.css('input[type=number]'));

  });

  it('Setting enabled to false disables the submit button', () => {
  
    fixture.detectChanges();
    expect(submitEl.nativeElement.disables).toBeTruthy();
  });
});
