import { NgModule } from "@angular/core";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatButtonModule } from "@angular/material/button";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "../app-routing.module";
import { MatIconModule } from '@angular/material/icon';


const materialModules = [
  MatIconModule
];
@NgModule({
  imports: [
    MatButtonModule,
    MatToolbarModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    AppRoutingModule,
    materialModules,
    
    // NgModule
  ],

  exports: [MatButtonModule, MatToolbarModule,materialModules],
})
export class LoginModuleModule {}
