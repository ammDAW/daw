import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConsultarTiempoService {

  private url = "http://api.openweathermap.org/data/2.5/"
  private apiKey = "1bf84d001f378f1d5675bc47080fb6b7"

  constructor(private http: HttpClient) {

  }

  getTiempoCiudad(id: string | number) {
    return this.http.get(this.url + "weather?id=" + id + "&appid=" + this.apiKey + "&units=metric")
  }

  getCiudadesPorPatron(patron: string) {
    return this.http.get(this.url + "find?q=" + patron + "&appid=" + this.apiKey)
  }
}
