import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AgradecimientosComponent } from './agradecimientos/agradecimientos.component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuscadorConsultasComponent } from './buscador-consultas/buscador-consultas.component';
import { EncabezadoComponent } from './encabezado/encabezado.component';
import { InicioComponent } from './inicio/inicio.component';
import { ListadoFavoritosComponent } from './listado-favoritos/listado-favoritos.component';
import { MenuNavegacionComponent } from './menu-navegacion/menu-navegacion.component';
import { Pagina404Component } from './pagina404/pagina404.component';
import { PieComponent } from './pie/pie.component';
import { RouterModule } from '@angular/router';
import { FavoritoComponent } from './favorito/favorito.component';


const rutas = [
  { path: 'home', component: InicioComponent},
  { path: 'favs', component: ListadoFavoritosComponent},
  { path: 'query', component: BuscadorConsultasComponent},
  { path: 'thank', component: AgradecimientosComponent},
  //{ path: 'detail', component:}
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: '**', component: Pagina404Component}
];

@NgModule({
  declarations: [
    AppComponent,
    EncabezadoComponent,
    MenuNavegacionComponent,
    PieComponent,
    FavoritoComponent,
    ListadoFavoritosComponent,
    BuscadorConsultasComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    //AppRoutingModule
    RouterModule.forRoot(rutas)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
