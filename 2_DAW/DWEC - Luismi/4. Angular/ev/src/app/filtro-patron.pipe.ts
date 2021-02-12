import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroPatron'
})
export class FiltroPatronPipe implements PipeTransform {

  transform(value: any[], patron: string): any[] { //el segundo any[] es lo que devuelve
    /*voy a filtrar el array de coches "value" para que se queden en el array
    sólo aquellos que cumplan el patron en su atributo ".nombre" */
    if(value && value.length){
      return value.filter(coche => coche.nombre.toLowerCase().includes(patron.toLowerCase()))
    }
    //si no consigo hacer un return antes, entonces devuelvo el array original
    return value;
  }
}
