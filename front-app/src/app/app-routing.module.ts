import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './form/usuario/usuario.component';


const routes: Routes = [
  // { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'register', loadChildren: './modules/register/register.module#RegisterModule' },
  { path: 'home', loadChildren: './modules/home/home.module#HomeModule' },
  { path: '', loadChildren: './modules/home/home.module#HomeModule' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
