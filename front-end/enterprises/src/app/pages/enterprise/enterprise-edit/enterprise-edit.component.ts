import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Enterprise } from 'src/app/model/enterprise';
import { EnterpriseService } from 'src/app/services/enterprise.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-enterprise-edit',
  templateUrl: './enterprise-edit.component.html',
  styleUrls: ['./enterprise-edit.component.css']
})
export class EnterpriseEditComponent implements OnInit {

  id:number;
  enterprise:Enterprise=new Enterprise();


  constructor(private enterpriseService:EnterpriseService, private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getEnterpriseById();

  }
  private getEnterpriseById(){
    this.enterpriseService.getEnterpriseById(this.id).subscribe((data) => {
      this.enterprise = data;
      console.log(this.enterprise);
   });  
  }
  goToEnterprise(){
    this.router.navigate(['/departments/department-list']);
    swal.fire('Empresa registrada',`La empresa ${this.enterprise.name} ha sido modificada con exito`,`success`);
  }
  modifiedEnterprise(){
    this.enterpriseService.creEnterprise(this.enterprise).subscribe(dato => {
      console.log(dato);
      this.goToEnterprise();
    },error => console.log(error));
  }
  onSubmit(){
    this.modifiedEnterprise();
  }

}
