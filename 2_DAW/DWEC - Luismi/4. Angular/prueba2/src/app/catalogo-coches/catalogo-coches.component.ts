import { Component, OnInit } from '@angular/core';
import { CarsService } from '../cars.service';


@Component({
  selector: 'app-catalogo-coches',
  templateUrl: './catalogo-coches.component.html',
  styleUrls: ['./catalogo-coches.component.css']
})
export class CatalogoCochesComponent implements OnInit {
  coches;

  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.carsService.getCars().subscribe(
      (response) => {
        this.coches = response;
      },
      (error) => {
        console.error(error);  
      }
    )
  }

}
