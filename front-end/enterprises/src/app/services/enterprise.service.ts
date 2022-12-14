import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Enterprise } from '../model/enterprise';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {
  
  private urlListar='http://localhost:8080/enterprise/enterprise-listar';

  constructor(private httpClient:HttpClient) { }
 

  getListEnterprise():Observable<Enterprise[]>{
    return this.httpClient.get<Enterprise[]>(`${this.urlListar}`);
  }

}
