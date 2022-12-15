import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/model/department';
import { Enterprise } from 'src/app/model/enterprise';
import { DepartmentService } from 'src/app/services/department.service';
import { EnterpriseService } from 'src/app/services/enterprise.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-department-edit',
  templateUrl: './department-edit.component.html',
  styleUrls: ['./department-edit.component.css']
})
export class DepartmentEditComponent implements OnInit {

  id:number;
  department:Department=new Department();
  enterprises!: Enterprise[];
  empresa:Enterprise=new Enterprise();
  constructor(private enterpriseService:EnterpriseService, private departmentService:DepartmentService,private router:Router,private route:ActivatedRoute) { 
    this.obtenerEnterprise();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getDepartmentById();
    
  }
  private obtenerEnterprise(){
    this.enterpriseService.getListEnterprise().subscribe((data) => {
      this.enterprises = data;
      
     });
    
  }
  private getDepartmentById(){
    this.departmentService.getDepartmentById(this.id).subscribe((data) => {
      this.department = data;
      console.log(this.department);
      
     });
    
  }
  goToDepartment(){
    this.router.navigate(['/departments/department-list']);
    swal.fire('Departamento registrado',`El departamento ${this.department.name} ha sido modificado con exito`,`success`);
  }
  modifiedDepartment(){
    this.department.id_enterprise=this.empresa;
    console.log(this.empresa.name);
    this.departmentService.creDepartment(this.department).subscribe(dato => {
      console.log(dato);
      this.goToDepartment();
    },error => console.log(error));
  }
  onSubmit(){
    this.modifiedDepartment();
  }

}
