import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';

@Component({
  selector: 'app-articulo',
  templateUrl: './articulo.component.html',
  styleUrls: ['./articulo.component.css']
})
export class ArticuloComponent implements OnInit {
  @Input() piezaparam;
  @Output() avisarAlPadre = new EventEmitter<string>();
  
  constructor() { }

  ngOnInit(): void {
  }

  eliminar(nombre){
    this.avisarAlPadre.emit(nombre);
  }
}
