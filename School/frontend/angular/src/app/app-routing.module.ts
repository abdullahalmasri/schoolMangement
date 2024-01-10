import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { HomePageComponent } from './home-page/home-page.component';


const routes: Routes = [
  // {
  //   path:'home',
  //   component:
  // },
  {
    path:'',
    component:LoginComponentComponent
  },
  { path: 'home', component: HomePageComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
