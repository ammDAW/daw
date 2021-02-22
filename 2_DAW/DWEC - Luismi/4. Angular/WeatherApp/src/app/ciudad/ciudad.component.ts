import { Component, Input, OnInit } from '@angular/core';
import { ConsultarTiempoService } from '../consultar-tiempo.service';

@Component({
  selector: 'app-ciudad',
  templateUrl: './ciudad.component.html',
  styleUrls: ['./ciudad.component.css']
})
export class CiudadComponent implements OnInit {

  @Input() id: number
  nombre = "ciudad_genérica"
  imagen = "murcia.jpg"
  temperatura = 0
  reales = false

  constructor(private consultarTiempo:ConsultarTiempoService) { }

  ngOnInit(): void {
    this.consultarTiempo.getTiempoCiudad(this.id).subscribe(
      (response) => {
        console.log('Response received');
        this.temperatura = Math.round(response["main"].temp);
        this.nombre = response["name"]
        this.reales = true;
      },
      (error) => {
        console.error('Request failed with error');
        console.error(error);
        // this.loading = false;
      }
    )
  }

}
