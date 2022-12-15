import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Enterprise } from 'src/app/model/enterprise';
import { EnterpriseService } from 'src/app/services/enterprise.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-enterprise-create',
  templateUrl: './enterprise-create.component.html',
  styleUrls: ['./enterprise-create.component.css']
})
export class EnterpriseCreateComponent implements OnInit {
  enterprise:Enterprise=new Enterprise();
  submitted:false;

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
    swal.fire('Empleado registrado',`El empleado ${this.enterprise.name} ha sido registrado con exito`,`success`);
  }

  onSubmit(){
    
    this.saveEnterprise();
  }

}
