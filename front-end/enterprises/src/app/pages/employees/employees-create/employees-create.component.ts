import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-employees-create',
  templateUrl: './employees-create.component.html',
  styleUrls: ['./employees-create.component.css']
})
export class EmployeesCreateComponent implements OnInit {
  employee !: Employee;
  constructor(private employeeService:EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }
  saveEmployee(){
    this.employeeService.creEmployee(this.employee).subscribe(dato => {
      console.log(dato);
      this.goToEmployee();
    },error => console.log(error));
  }

  goToEmployee(){
    this.router.navigate(['/employees/employee-list']);
    //swal('Empleado registrado',`El empleado ${this.employee.name} ha sido registrado con exito`,`success`);
  }

  onSubmit(){
    this.saveEmployee();
  }

}
