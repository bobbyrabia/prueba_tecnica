import { Component, OnInit } from '@angular/core';
import { Enterprise } from 'src/app/model/enterprise';
import { EnterpriseService } from 'src/app/services/enterprise.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enterprise-list',
  templateUrl: './enterprise-list.component.html',
  styleUrls: ['./enterprise-list.component.css']
})
export class EnterpriseListComponent implements OnInit {
  enterprises!: Enterprise[];
  
  constructor(private enterpriseSvc:EnterpriseService,private router:Router) { 
    
    this.obtenerEnterprise()
  }

  ngOnInit(): void {
    
  }
  

  private obtenerEnterprise(){
      this.enterpriseSvc.getListEnterprise().subscribe((data) => {
        this.enterprises = data;
        
       });
      
  }
  updEnterprise(id:number){
    this.router.navigate(['enterprise/enterprise-edit',id]);
  }


}
