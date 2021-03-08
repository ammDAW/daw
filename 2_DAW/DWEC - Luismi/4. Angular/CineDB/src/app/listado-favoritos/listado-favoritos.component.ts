import { Component, OnInit } from '@angular/core';
import { FavoritosService } from '../favoritos.service';

@Component({
  selector: 'app-listado-favoritos',
  templateUrl: './listado-favoritos.component.html',
  styleUrls: ['./listado-favoritos.component.css']
})
export class ListadoFavoritosComponent implements OnInit {
  /*favoritos = [
  ]*/
  constructor(private favoritoService: FavoritosService) { 

  }

  ngOnInit(): void {
    /*this.favoritoService.getFavoritos().subscribe(
      (respose) => {
        this.favoritos = respose;
      }
      (error) => {
        console.error(error);
      }
    )*/
    }
   getFavoritos(){
    return this.favoritoService.getFavoritos();
    //return this.favoritos
  } 

  

}
