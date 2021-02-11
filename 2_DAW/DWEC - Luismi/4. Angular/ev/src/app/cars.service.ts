import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private url = "https://my-json-server.typicode.com/luismiguel-fernandez/angular/coches"
  constructor() { }
}
