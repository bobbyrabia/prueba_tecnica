import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/model/department';
import { Enterprise } from 'src/app/model/enterprise';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent implements OnInit {

  departments!:Department[];
  enterprise!:Enterprise[];
  
  constructor(private departmentService:DepartmentService) { 
    
    this.obtenerDepartment();
    
  }

  ngOnInit(): void {
    
  }
  

  private obtenerDepartment(){
      this.departmentService.getListDepartment().subscribe((data) => {
        this.departments = data;
        //console.log(this.departments);
        //console.log(this.departments[0].id_enterprise.name);

       });
       
       
      
  }

}
