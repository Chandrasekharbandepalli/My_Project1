/*import { HttpClient} from "@angular/common/http";
import { PatientService } from "./patient.service";
import { of } from 'rxjs';

fit("Patient",()=>
{
  let patients:Patient =
  {
    id: 1,
    name: "chandu",
    visitedDoctor:"Chandra Sekhar",
    dateOfVisit:"20-08-2022",
    prescription: "Heart Issue",
   
  }

  httpClientSpy.post.and.returnValue(of(patients))
  service.createPatient(patients).subscribe({
    next:(res)=>
    {
      expect(res).toEqual(patients);
    }
  })
});*/
