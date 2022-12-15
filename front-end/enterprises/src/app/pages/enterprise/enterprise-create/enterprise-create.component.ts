import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Enterprise } from 'src/app/model/enterprise';
import { EnterpriseService } from 'src/app/services/enterprise.service';

@Component({
  selector: 'app-enterprise-create',
  templateUrl: './enterprise-create.component.html',
  styleUrls: ['./enterprise-create.component.css']
})
export class EnterpriseCreateComponent implements OnInit {
  enterprise : Enterprise;
  model = {
    address:"",
    name:"",
    phone:""
    
  };
  constructor(private enterpriseService:EnterpriseService,private router:Router) { }

  ngOnInit(): void {
  }
  saveEnterprise(){
    this.enterpriseService.creEnterprise(this.enterprise).subscribe(dato => {
      console.log(dato);
      this.goToEnterprise();
    },error => console.log(error));
  }

  goToEnterprise(){
    this.router.navigate(['/enterprise/enterprise-list']);
    //swal('Empleado registrado',`El empleado ${this.employee.name} ha sido registrado con exito`,`success`);
  }

  onSubmit(){
    console.log(this.model.address);
    this.enterprise.address=this.model.address;
    this.enterprise.name=this.model.name;
    this.enterprise.phone=this.model.phone;
    this.saveEnterprise();
  }

}
