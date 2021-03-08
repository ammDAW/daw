import { Component, OnInit } from '@angular/core';
import { BaseDatosCineService } from '../base-datos-cine.service';
import { FavoritosService } from '../favoritos.service';

@Component({
  selector: 'app-buscador-consultas',
  templateUrl: './buscador-consultas.component.html',
  styleUrls: ['./buscador-consultas.component.css']
})
export class BuscadorConsultasComponent implements OnInit {
  resultados = []
  constructor(private baseDatosCine: BaseDatosCineService,
              private favoritos: FavoritosService) { }

  ngOnInit(): void {
  }


  buscarPelicula(patron:string){
    //this.resultados = [];
    this.baseDatosCine.getPeliculasNombre(patron).subscribe(
      (response)=>{
        console.table(response);
        response['Search'].forEach(element =>{
          let nuevoResultado = {
            imdbID: element.imdbID,
            Title: element.Title,
            Poster: element.Poster,
            Type: element.Type,
            Year: element.Year
          }
          this.resultados.push(nuevoResultado)
        })
      },
      (error) => {
        console.error(error);
      }
    )
  }

  addFavoritos(nuevoFavorito: any){
    if(!this.favoritos.existe(nuevoFavorito)){
      this.favoritos.addFavorito(nuevoFavorito);
    }
  }

}
