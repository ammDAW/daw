import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccesoDatosService {
  private url = "https://my-json-server.typicode.com/ammDAW/daw/piezas";
  /* piezas = [
    {
      nombre: "AMD Ryzen 5 3600",
      precio: 249.00,
      imagen: "https://thumb.pccomponentes.com/w-530-530/articles/21/213019/5-3.jpg",
      stock: true
    },

    {
      nombre: "MSI B550i",
      precio: 179.00,
      imagen: "https://thumb.pccomponentes.com/w-530-530/articles/30/302204/1849-msi-b550-a-pro.jpg",
      stock: false
    }
  ]; */
  
  constructor(private http: HttpClient) { }

  getDatos(){
    //return this.piezas;
    return this.http.get(this.url); //devuelve un observable
  }
}
