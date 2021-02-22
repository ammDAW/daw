import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mis-ciudades',
  templateUrl: './mis-ciudades.component.html',
  styleUrls: ['./mis-ciudades.component.css']
})
export class MisCiudadesComponent implements OnInit {

  ciudades = [2513413,2988507,2267057]
  // [Murcia,Paris,Lisboa]

  constructor() { }

  ngOnInit(): void {
  }

}
