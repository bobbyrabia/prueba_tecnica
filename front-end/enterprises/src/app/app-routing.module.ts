import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnterpriseListComponent } from './pages/enterprise/enterprise-list/enterprise-list.component';

const routes: Routes = [
  {path:'enterprise/enterprise-list',component:EnterpriseListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
