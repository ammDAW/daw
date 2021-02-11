import { Component, OnInit } from '@angular/core';
import { CarsService } from '../cars.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  fabricantes;
  tecnologias;

  constructor(private accesoDatos: CarsService) { }

  ngOnInit(): void {
    this.accesoDatos.getMakers().subscribe(
      (data) => {this.fabricantes = data;}
    );

    this.accesoDatos.getTechs().subscribe(
      (data) => {this.tecnologias = data;}
    );
  }
}
