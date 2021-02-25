import { Component, OnInit } from '@angular/core';
import { ListaCiudadesService } from '../lista-ciudades.service';

@Component({
  selector: 'app-mis-ciudades',
  templateUrl: './mis-ciudades.component.html',
  styleUrls: ['./mis-ciudades.component.css']
})
export class MisCiudadesComponent implements OnInit {

  constructor(private listaCiudades: ListaCiudadesService) { }

  ngOnInit(): void {
  }

  getCiudades(){
    return this.listaCiudades.getCiudades();
  }
}
