import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarsService } from '../cars.service';

@Component({
  selector: 'app-detalles-coche',
  templateUrl: './detalles-coche.component.html',
  styleUrls: ['./detalles-coche.component.css']
})
export class DetallesCocheComponent implements OnInit {
  cocheparam;
  //recibido = false;
  constructor(
    private param: ActivatedRoute,
    private carsService: CarsService) { 
  }

  ngOnInit(): void {
    const idCoche = this.param.snapshot.paramMap.get("id"); //recoger el id que viene por ruta 
    this.carsService.getId(idCoche).subscribe(
      (response) => {
        this.cocheparam = response;
        //this.recibido = true;
      },
      (error) => {
        console.error(error);
        //this.recibido = true;
      }  
    );
  }

}
