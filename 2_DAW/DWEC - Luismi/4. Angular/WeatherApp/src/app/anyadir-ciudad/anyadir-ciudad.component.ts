import { Component, OnInit } from '@angular/core';
import { ConsultarTiempoService } from '../consultar-tiempo.service';

@Component({
  selector: 'app-anyadir-ciudad',
  templateUrl: './anyadir-ciudad.component.html',
  styleUrls: ['./anyadir-ciudad.component.css']
})
export class AnyadirCiudadComponent implements OnInit {

  resultados = []

  constructor(private consultarTiempo:ConsultarTiempoService) { }

  ngOnInit(): void {
  }

  buscarCiudades(patron:string){
    this.consultarTiempo.getCiudadesPorPatron(patron).subscribe(
      (response) => {
        console.log('Response received');
        console.table(response)
      },
      (error) => {
        console.error('Request failed with error');
        console.error(error);
      }
    )
  }

}
