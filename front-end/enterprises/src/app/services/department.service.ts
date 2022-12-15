import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../model/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private urlListar='http://localhost:8080/department/department-listar';
  private urlCrear='http://localhost:8080/department/department-create';
  private urlEditar='http://localhost:8080/department/department-edit';


  constructor(private httpClient:HttpClient) { }
 

  getListDepartment():Observable<Department[]>{
    return this.httpClient.get<Department[]>(`${this.urlListar}`);
  }
  creDepartment(department:Department) : Observable<Object>{
    return this.httpClient.post(`${this.urlCrear}`,department);
  }

  
  updDepartment(id:number,department:Department) : Observable<Object>{
    return this.httpClient.put(`${this.urlEditar}/${id}`,department);
  }
}
