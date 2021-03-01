import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListaCiudadesService {

  private ciudades = [
    {id: 2513413, name:'Murcia'},
    {id: 2988507, name:'Paris'},
    {id: 2267057, name:'Lisbon'}
  ]
  // [Murcia,Paris,Lisboa]

  constructor() { }

  
  getCiudades(){
    return this.ciudades;
  }

  /*addCiudad(id: number){
    if(id > 0)
      this.ciudades.push(id)
  }*/

  addCiudad(nuevaCiudad: any){
    if (nuevaCiudad.id > 0)
      this.ciudades.push(nuevaCiudad);
  }

  removeCiudad(id: number){
    this.ciudades = this.ciudades.filter(ciudad => ciudad.id != id);
  }

  incluye(ciudad: any){
    /*for (let i=0;i<this.ciudades.length; i++){
      if (this.ciudades[i].id == ciudades.id) return true
    }
    return false*/
    let ciudadesFiltradas = this.ciudades.filter(c => c.id == ciudad.id)
    return (ciudadesFiltradas.length > 0)
  }

  clearCiudades(){
    this.ciudades = [];
  }
}
