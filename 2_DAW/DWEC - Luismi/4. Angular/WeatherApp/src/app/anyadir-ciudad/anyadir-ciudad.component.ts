import { Component, OnInit } from '@angular/core';
import { ConsultarTiempoService } from '../consultar-tiempo.service';
import { ListaCiudadesService } from '../lista-ciudades.service';

@Component({
  selector: 'app-anyadir-ciudad',
  templateUrl: './anyadir-ciudad.component.html',
  styleUrls: ['./anyadir-ciudad.component.css']
})
export class AnyadirCiudadComponent implements OnInit {

  resultados = [];

  constructor(private consultarTiempo:ConsultarTiempoService,
              private listaCiudades:ListaCiudadesService) { }

  ngOnInit(): void {
  }

  buscarCiudades(patron:string){
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

  addCiudad(id: number){
    console.log(`Vamos a añadir la ciudad con ID=${id}`)
    //añadir la nueva ciudad al array de ciudades que está en el componente MisCiudades
    this.listaCiudades.addCiudad(id)
  }
}
