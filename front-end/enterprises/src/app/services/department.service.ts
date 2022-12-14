import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../model/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private urlListar='http://localhost:8080/department/department-listar';

  constructor(private httpClient:HttpClient) { }
 

  getListEnterprise():Observable<Department[]>{
    return this.httpClient.get<Department[]>(`${this.urlListar}`);
  }
}
