import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MisCiudadesComponent } from './mis-ciudades/mis-ciudades.component';
import { CiudadComponent } from './ciudad/ciudad.component';
import { AnyadirCiudadComponent } from './anyadir-ciudad/anyadir-ciudad.component';

@NgModule({
  declarations: [
    AppComponent,
    MisCiudadesComponent,
    CiudadComponent,
    AnyadirCiudadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
