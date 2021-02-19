import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarCardComponent } from './car-card/car-card.component';
import { CarRowComponent } from './car-row/car-row.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FiltroPatronPipe } from './filtro-patron.pipe';
import { FiltroFabricantePipe } from './filtro-fabricante.pipe';
import {PresentacionComponent} from './presentacion/presentacion.component';
import {CatalogoCochesComponent} from './catalogo-coches/catalogo-coches.component';
import {ContactoComponent} from './contacto/contacto.component';
import {Pagina404Component} from './pagina404/pagina404.component';

import {RouterModule} from '@angular/router';
import {CarDetailsComponent} from './car-details/car-details.component';

const rutas = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: PresentacionComponent},
  { path: 'catalogo', component: CatalogoCochesComponent},
  { path: 'contacto', component: ContactoComponent},
  { path: 'ev/:id', component: CarDetailsComponent},
  { path: '**', component: Pagina404Component}
]

@NgModule({
  declarations: [
    AppComponent,
    CarCardComponent,
    CarRowComponent,
    SidebarComponent,
    FiltroPatronPipe,
    FiltroFabricantePipe
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(rutas)
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
