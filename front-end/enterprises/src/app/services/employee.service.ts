import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private urlListar='http://localhost:8080/employeer/employees-listar';

  constructor(private httpClient:HttpClient) { }
 

  getListEnterprise():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.urlListar}`);
  }
}
