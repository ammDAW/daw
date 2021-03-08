import { Component, Input, OnInit } from '@angular/core';
import { BaseDatosCineService } from '../base-datos-cine.service';
import { FavoritosService } from '../favoritos.service';

@Component({
  selector: 'app-favorito',
  templateUrl: './favorito.component.html',
  styleUrls: ['./favorito.component.css']
})
export class FavoritoComponent implements OnInit {
  @Input() id
  titulo = "";
  imagen = "";
  imdbID = "" ;
  constructor(private listadoPeliculas:BaseDatosCineService, private favorito:FavoritosService) { }

  ngOnInit(): void {
    this.listadoPeliculas.getPeliculasId(this.id).subscribe(
      (response) => {
        this.titulo = response["Title"]
        this.imagen = response["Poster"]
        this.imdbID = response["imdbID"]
      },
      (error) => {
        console.error(error);
      }  
    )
  }

  borrarFavorito(imdbID){
    this.favorito.removeFavorito(imdbID);
  }

}
