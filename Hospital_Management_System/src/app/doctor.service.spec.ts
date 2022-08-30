import { HttpClient} from "@angular/common/http";
import { DoctorService } from "./doctor.service";
import { of } from 'rxjs';

describe('Doctor Service', ()=> {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let doctorService: DoctorService;
  let DOCTOR = [
    {
      id: 1,
      name: "chandu",
      age: 25,
      gender: "Male",
      specialist: "Heart",
      numberOfPatients: 10,

    },
    {
      id: 2,
      name: "geetha",
      age: 25,
      gender: "FeMale",
      specialist: "Brain",
      numberOfPatients: 5,

    },
    {
      id: 3,
      name: "ram",
      age: 25,
      gender: "Male",
      specialist: "Eye",
      numberOfPatients: 10,

    },

  ];
  beforeEach(()=> {
    httpClientSpy = jasmine.createSpyObj('HttpClient',['get']);
    doctorService = new DoctorService(httpClientSpy);
  });

  describe('getAllDoctors', () => {
    fit('should return expected doctor',()=> {
      httpClientSpy.get.and.returnValue(of(DOCTOR));
      doctorService.getAllDoctors().subscribe({
        next: (doctor) => {
          expect(doctor).toEqual(DOCTOR);
        },
        error: () => {},
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
  });
});

});