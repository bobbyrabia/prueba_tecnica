import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private urlListar='http://localhost:8080/employeer/employees-listar';
  private urlCrear='http://localhost:8080/employeer/employees-create';
  private urlEditar='http://localhost:8080/employeer/employees-edit';
  private urlEmployeeId='http://localhost:8080/employeer/employeeid';

  constructor(private httpClient:HttpClient) { }
 
  getEmployeeById(id:number):Observable<Employee>{ 
    return this.httpClient.get<Employee>(`${this.urlEmployeeId}/${id}`);
  }
  getListEmployee():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.urlListar}`);
  }
  creEmployee(employee:Employee) : Observable<Object>{
    return this.httpClient.post(`${this.urlCrear}`,employee);
  }

  
  updEmployee(id:number,employee:Employee) : Observable<Object>{
    return this.httpClient.put(`${this.urlEditar}/${id}`,employee);
  }

}
