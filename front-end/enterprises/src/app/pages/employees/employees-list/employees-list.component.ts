import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
  employees:Employee[] | undefined;
  
  constructor(private employSvc:EmployeeService) { 
    
    this.obtenerEmployee()
  }

  ngOnInit(): void {
    
  }
  

  private obtenerEmployee(){
      this.employSvc.getListEnterprise().subscribe((data: Employee[]) => {
        this.employees = data;
        console.log(data);
       });
      
  }

}
