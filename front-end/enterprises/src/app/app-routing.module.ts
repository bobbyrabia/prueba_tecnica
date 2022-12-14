import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentCreateComponent } from './pages/departments/department-create/department-create.component';
import { DepartmentEditComponent } from './pages/departments/department-edit/department-edit.component';
import { DepartmentListComponent } from './pages/departments/department-list/department-list.component';
import { EmployeesCreateComponent } from './pages/employees/employees-create/employees-create.component';
import { EmployeesEditComponent } from './pages/employees/employees-edit/employees-edit.component';
import { EmployeesListComponent } from './pages/employees/employees-list/employees-list.component';
import { EnterpriseCreateComponent } from './pages/enterprise/enterprise-create/enterprise-create.component';
import { EnterpriseEditComponent } from './pages/enterprise/enterprise-edit/enterprise-edit.component';
import { EnterpriseListComponent } from './pages/enterprise/enterprise-list/enterprise-list.component';

const routes: Routes = [
  {path:'enterprise/enterprise-list',component:EnterpriseListComponent},
  {path:'enterprise/enterprise-edit',component:EnterpriseEditComponent},
  {path:'enterprise/enterprise-create',component:EnterpriseCreateComponent},
  {path:'departments/department-list',component:DepartmentListComponent},
  {path:'departments/department-edit',component:DepartmentEditComponent},
  {path:'departments/department-create',component:DepartmentCreateComponent},
  {path:'employees/employee-list',component:EmployeesListComponent},
  {path:'employees/employee-edit',component:EmployeesEditComponent},
  {path:'employees/employee-create',component:EmployeesCreateComponent},
  {path:'**',redirectTo:'',pathMatch:'full'},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
