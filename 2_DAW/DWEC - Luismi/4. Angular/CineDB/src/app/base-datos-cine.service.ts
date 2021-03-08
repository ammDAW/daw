import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BaseDatosCineService {
  private url = "http://www.omdbapi.com/"
  private apiKey = "6bd6250b"

  constructor(private http: HttpClient) { }

  getPeliculasNombre(nombre){
    return this.http.get(this.url + "?s=" + nombre + "&apikey=" + this.apiKey)
  }

  getPeliculasId(id){
    return this.http.get(this.url + "?i=" + id + "&apikey=" + this.apiKey)
  }
}
