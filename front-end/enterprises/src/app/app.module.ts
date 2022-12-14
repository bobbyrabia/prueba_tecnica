import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EnterpriseListComponent } from './pages/enterprise/enterprise-list/enterprise-list.component';
import { EnterpriseEditComponent } from './pages/enterprise/enterprise-edit/enterprise-edit.component';
import { DepartmentListComponent } from './pages/departments/department-list/department-list.component';
import { DepartmentEditComponent } from './pages/departments/department-edit/department-edit.component';
import { DepartmentCreateComponent } from './pages/departments/department-create/department-create.component';
import { EnterpriseCreateComponent } from './pages/enterprise/enterprise-create/enterprise-create.component';
import { EmployeesListComponent } from './pages/employees/employees-list/employees-list.component';
import { EmployeesCreateComponent } from './pages/employees/employees-create/employees-create.component';
import { EmployeesEditComponent } from './pages/employees/employees-edit/employees-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    EnterpriseListComponent,
    EnterpriseEditComponent,
    DepartmentListComponent,
    DepartmentEditComponent,
    DepartmentCreateComponent,
    EnterpriseCreateComponent,
    EmployeesListComponent,
    EmployeesCreateComponent,
    EmployeesEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
