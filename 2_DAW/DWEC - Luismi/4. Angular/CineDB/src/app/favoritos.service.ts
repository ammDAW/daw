import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FavoritosService {
  private favoritos = [
  ]
  constructor() { 
    this.favoritos.push({
      "Poster": "https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
      "Title": "Blade Runner",
      "Type": "movie",
      "Year": "1982",
      "imdbID": "tt0083658"
    })
    this.favoritos.push({
      "Poster": "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
      "Title": "The Matrix",
      "Type": "movie",
      "Year": "1999",
      "imdbID": "tt0133093"
    })
  }

  getFavoritos(){
    console.log(this.favoritos)
    return this.favoritos;
  }

  existe(fav: any){
    for (let i=0;i<this.favoritos.length; i++){
      if (this.favoritos[i].imdbID == fav.imdbID) return true
    }
    return false
  }

  addFavorito(nuevoFavorito: any){
    /*if (nuevoFavorito.imdbID > 0)*/
      this.favoritos.push(nuevoFavorito);
  }

  removeFavorito(imdbID){{
      this.favoritos = this.favoritos.filter(favorito => favorito.imdbID != imdbID);
    }
  }
}
