import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private url = "https://my-json-server.typicode.com/ammDAW/daw/"
  
  constructor(private http: HttpClient) { }

  getCars(){
    return this.http.get(this.url + "coches");
  }

  getMakers(){
    return this.http.get(this.url + "fabricantes");
  }

  getTechs(){
    return this.http.get(this.url + "tecnologias");
  }

  getCar(id: number | string){
    return this.http.get(this.url + "coches/" + id);
  }
}
