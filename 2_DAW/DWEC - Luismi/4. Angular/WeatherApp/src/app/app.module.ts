import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { MisCiudadesComponent } from './mis-ciudades/mis-ciudades.component';
import { CiudadComponent } from './ciudad/ciudad.component';
import { AnyadirCiudadComponent } from './anyadir-ciudad/anyadir-ciudad.component';
import { GestionarCiudadesComponent } from './gestionar-ciudades/gestionar-ciudades.component';
import { BorrarCiudadesComponent } from './borrar-ciudades/borrar-ciudades.component';

const rutas = [
    { path: 'home', component: MisCiudadesComponent},
    { path: 'manage', component: GestionarCiudadesComponent},
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    //{ path: '**', component: Pagina404Component}
    { path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    MisCiudadesComponent,
    CiudadComponent,
    AnyadirCiudadComponent,
    GestionarCiudadesComponent,
    BorrarCiudadesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(rutas)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
