import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Enterprise } from '../model/enterprise';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {
  
  private urlListar='http://localhost:8080/enterprise/enterprise-listar';
  private urlCrear='http://localhost:8080/enterprise/enterprise-create';
  private urlEditar='http://localhost:8080/enterprise/enterprise-edit';

  constructor(private httpClient:HttpClient) { }
 

  getListEnterprise():Observable<Enterprise[]>{
    return this.httpClient.get<Enterprise[]>(`${this.urlListar}`);
  }

  creEnterprise(enterprise:Enterprise) : Observable<Object>{
    return this.httpClient.post(`${this.urlCrear}`,enterprise);
  }

  
  updEnterprise(id:number,enterprise:Enterprise) : Observable<Object>{
    return this.httpClient.put(`${this.urlEditar}/${id}`,enterprise);
  }
  


}
