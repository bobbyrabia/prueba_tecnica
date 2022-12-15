import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-employees-edit',
  templateUrl: './employees-edit.component.html',
  styleUrls: ['./employees-edit.component.css']
})
export class EmployeesEditComponent implements OnInit {

  id:number;
  employee:Employee=new Employee();
  
  constructor(private employeeService:EmployeeService, private router:Router,private route:ActivatedRoute) {
    
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getEmployeeById();
  }
  private getEmployeeById(){
    this.employeeService.getEmployeeById(this.id).subscribe((data) => {
      this.employee = data;
      console.log(this.employee);
      
   });    
  }
  goToEmployee(){
    this.router.navigate(['/departments/department-list']);
    swal.fire('Empleado registrado',`El empleado ${this.employee.name} ha sido modificado con exito`,`success`);
  }
  modifiedEmployee(){
    this.employeeService.creEmployee(this.employee).subscribe(dato => {
      console.log(dato);
      this.goToEmployee();
    },error => console.log(error));
  }
  onSubmit(){
    this.modifiedEmployee();
  }

}
