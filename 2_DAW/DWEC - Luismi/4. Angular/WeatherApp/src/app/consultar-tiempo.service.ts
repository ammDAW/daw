import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConsultarTiempoService {

  private url = "http://api.openweathermap.org/data/2.5/"
  private apiKey = "0617ecda468c5e9492d75f4388b1ddf5"

  constructor(private http: HttpClient) {

  }

  getTiempoCiudad(id: string | number) {
    return this.http.get(this.url + "weather?id=" + id + "&appid=" + this.apiKey + "&units=metric")
  }

  getCiudadesPorPatron(patron: string) {
    return this.http.get(this.url + "find?q=" + patron + "&appid=" + this.apiKey)
  }
}
