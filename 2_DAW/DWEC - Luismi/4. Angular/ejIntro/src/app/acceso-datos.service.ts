import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccesoDatosService {
  private url = "https://my-json-server.typicode.com/ammDAW/daw/piezas";
  
  constructor(private http: HttpClient) { }

  getDatos(){
    //return this.piezas;
    return this.http.get(this.url); //devuelve un observable
  }
}
