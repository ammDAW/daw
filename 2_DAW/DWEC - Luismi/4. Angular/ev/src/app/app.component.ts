import { Component, OnInit } from '@angular/core';
import { CarsService } from './cars.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  coches;
  title = 'ev';
  vistaBigCard = true;
  loading = false;
  patron = "";
  fab = "0";

  constructor(private carsService: CarsService){
  }

  ngOnInit(){ //recepcion de datos de coches
    this.loading = true;
    this.carsService.getCars().subscribe(
      (response) => {
        console.log('Response received')
        this.coches = response;
        this.loading = false;
      },
      (error) => {
        console.error('Request failed with error');
        console.error(error);
        this.loading = false;
      }
    )
  }

  cambiarVista(){
    this.vistaBigCard = !this.vistaBigCard;
  }

  establecerNuevoFiltroPatron(patron){
    this.patron = patron;
  }

  establecerNuevoFiltroFab(idFab){
    this.fab = idFab;
  }
}
