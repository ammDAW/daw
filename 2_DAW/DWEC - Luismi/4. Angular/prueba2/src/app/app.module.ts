import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CatalogoCochesComponent } from './catalogo-coches/catalogo-coches.component';
import { CarCardComponent } from './car-card/car-card.component';
import { PresentacionComponent } from './presentacion/presentacion.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { DetallesCocheComponent } from './detalles-coche/detalles-coche.component';

const rutas = [
  { path: 'presentacion', component: PresentacionComponent},
  { path: 'catalogo', component: CatalogoCochesComponent},
  { path: 'detalles/:id', component: DetallesCocheComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    CatalogoCochesComponent,
    CarCardComponent,
    PresentacionComponent,
    DetallesCocheComponent
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
