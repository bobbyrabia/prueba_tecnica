import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from 'src/app/model/department';
import { Enterprise } from 'src/app/model/enterprise';
import { DepartmentService } from 'src/app/services/department.service';
import { EnterpriseService } from 'src/app/services/enterprise.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-department-create',
  templateUrl: './department-create.component.html',
  styleUrls: ['./department-create.component.css']
})
export class DepartmentCreateComponent implements OnInit {
  enterprises!: Enterprise[];
  empresa:Enterprise=new Enterprise();
  department:Department=new Department();
  constructor(private enterpriseService:EnterpriseService, private departmentService:DepartmentService, private router:Router) { this.obtenerEnterprise()}

  ngOnInit(): void {
  }
  private obtenerEnterprise(){
    this.enterpriseService.getListEnterprise().subscribe((data) => {
      this.enterprises = data;
      
     });
    
  }
  saveDepartment(){
    this.department.id_enterprise=this.empresa;
    console.log(this.empresa.name);
    this.departmentService.creDepartment(this.department).subscribe(dato => {
      console.log(dato);
      this.goToDepartment();
    },error => console.log(error));
  }
  goToDepartment(){
    this.router.navigate(['/departments/department-list']);
    swal.fire('Empleado registrado',`El empleado ${this.department.name} ha sido registrado con exito`,`success`);
  }
  onSubmit(){
    this.saveDepartment();
  }




}
