import { Component, OnInit } from '@angular/core';
import { ConsultarTiempoService } from '../consultar-tiempo.service';
import { ListaCiudadesService } from '../lista-ciudades.service';

@Component({
  selector: 'app-anyadir-ciudad',
  templateUrl: './anyadir-ciudad.component.html',
  styleUrls: ['./anyadir-ciudad.component.css']
})
export class AnyadirCiudadComponent implements OnInit {

  resultados = []; //lista que aparece tras darle al botón buscar
  msgAddCityOK = false; //boolean para el mensaje de alerta en el *ngIf
  msgAddCityError = false; //boolean para el mensaje de alerta en el *ngIf

  constructor(private consultarTiempo:ConsultarTiempoService,
              private listaCiudades:ListaCiudadesService) { }

  ngOnInit(): void {
  }

  buscarCiudades(patron:string){
    this.resultados = []; //limpiar para que no se apilen las búsquedas
    this.consultarTiempo.getCiudadesPorPatron(patron).subscribe(
      (response) => {
        console.log('Response received');
        console.table(response);
        response['list'].forEach(element => {
          let nuevoResultado = {
            id: element.id,
            name: element.name,
            country: element['sys'].country
          }
          this.resultados.push(nuevoResultado)   
        });
      },
      (error) => {
        console.error('Request failed with error');
        console.error(error);
      }
    )
  }

  addCiudad(nuevaCiudad: any){
    this.msgAddCityOK = false;
    this.msgAddCityError = false;

    //añadir ciudad si no existe previamente
    if(!this.listaCiudades.incluye(nuevaCiudad)){
      this.listaCiudades.addCiudad(nuevaCiudad);
      this.msgAddCityOK = true;
    }
    else {
      this.msgAddCityError = true;
    }
    setTimeout(() => this.msgAddCityOK = false, 3000)
    setTimeout( () => this.msgAddCityError = false, 3000)         
  }
}
